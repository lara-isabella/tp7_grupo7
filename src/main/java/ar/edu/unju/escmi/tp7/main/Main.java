package ar.edu.unju.escmi.tp7.main;

import java.util.Scanner;
import java.time.LocalDate;

import ar.edu.unju.escmi.tp7.collections.*;
import ar.edu.unju.escmi.tp7.dominio.*;
import ar.edu.unju.escmi.tp7.exceptions.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Precarga de datos
        CollectionTarjetaCredito.precargarTarjetas();
        CollectionCliente.precargarClientes();
        CollectionProducto.precargarProductos();
        CollectionStock.precargarStocks();

        int opcion = 0;
        do {
            System.out.println("\n====== MENÚ PRINCIPAL =====");
            System.out.println("1 - Realizar una venta");
            System.out.println("2 - Revisar compras realizadas por un cliente");
            System.out.println("3 - Mostrar lista de productos");
            System.out.println("4 - Consultar stock disponible");
            System.out.println("5 - Revisar créditos de un cliente");
            System.out.println("6 - Salir");
            System.out.print("Ingrese su opción: ");

            try {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        realizarVenta();
                        break;
                    case 2:
                        revisarCompras();
                        break;
                    case 3:
                        mostrarProductos();
                        break;
                    case 4:
                        mostrarStock();
                        break;
                    case 5:
                        revisarCreditos();
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }

            } catch (Exception e) {
                System.out.println("⚠️ Error: entrada inválida. Intente nuevamente.");
                scanner.nextLine(); // limpiar buffer
            }

        } while (opcion != 6);

        scanner.close();
    }

    // ============================================================
    // OPCIÓN 1: REALIZAR UNA VENTA
    // ============================================================
    public static void realizarVenta() {
        try {
            System.out.print("Ingrese DNI del cliente: ");
            long dni = scanner.nextLong();

            Cliente cliente = CollectionCliente.buscarCliente(dni);
            if (cliente == null)
                throw new UsuarioNoEncontradoException("Cliente no encontrado.");

            System.out.print("Ingrese código del producto: ");
            long codigo = scanner.nextLong();

            Producto producto = CollectionProducto.buscarProducto(codigo);
            if (producto == null)
                throw new ProductoNoEncontradoException("Producto no encontrado.");

            Stock stock = CollectionStock.buscarStock(producto);
            if (stock == null || !stock.validarStockDisponible(1))
                throw new StockNoSuficienteException("No hay stock disponible para este producto.");

            // Simulación de crédito
            TarjetaCredito tarjeta = cliente.getTarjeta();
            if (tarjeta == null)
                throw new EntradaInvalidaException("El cliente no tiene tarjeta asociada.");

            Credito credito = new Credito(cliente, producto, tarjeta);
            credito.validarMonto();
            credito.generarCuotas();

            CollectionCredito.agregarCredito(credito);
            CollectionStock.reducirStock(stock, 1);

            // Creamos una factura básica con detalle
            Detalle detalle = new Detalle(1, producto);
            Factura factura = new Factura(LocalDate.now(), generarNroFactura(), cliente);
            factura.getDetalles().add(detalle);
            CollectionFactura.agregarFactura(factura);

            System.out.println("\n✅ Venta realizada con éxito!");
            System.out.println(factura);

        } catch (UsuarioNoEncontradoException | ProductoNoEncontradoException |
                 StockNoSuficienteException | EntradaInvalidaException e) {
            System.out.println("⚠️ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("⚠️ Error inesperado: " + e.getMessage());
        }
    }

    // ============================================================
    // OPCIÓN 2: REVISAR COMPRAS DE UN CLIENTE
    // ============================================================
    public static void revisarCompras() {
        System.out.print("Ingrese DNI del cliente: ");
        long dni = scanner.nextLong();
        boolean encontrado = false;

        for (Factura f : CollectionFactura.facturas) {
            if (f.getCliente().getDni() == dni) {
                System.out.println(f);
                encontrado = true;
            }
        }

        if (!encontrado)
            System.out.println("El cliente no posee compras registradas.");
    }

    // ============================================================
    // OPCIÓN 3: MOSTRAR PRODUCTOS
    // ============================================================
    public static void mostrarProductos() {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        for (Producto p : CollectionProducto.productos) {
            System.out.println(p);
        }
    }

    // ============================================================
    // OPCIÓN 4: CONSULTAR STOCK
    // ============================================================
    public static void mostrarStock() {
        System.out.println("\n--- STOCK DISPONIBLE ---");
        CollectionStock.mostrarStocks();
    }

    // ============================================================
    // OPCIÓN 5: REVISAR CRÉDITOS DE UN CLIENTE
    // ============================================================
    public static void revisarCreditos() {
        System.out.print("Ingrese DNI del cliente: ");
        long dni = scanner.nextLong();

        Credito credito = CollectionCredito.buscarCreditoPorDni(dni);
        if (credito != null) {
            credito.mostrarCredito();
        } else {
            System.out.println("El cliente no posee créditos registrados.");
        }
    }

    // ============================================================
    // MÉTODO AUXILIAR: GENERAR NRO FACTURA
    // ============================================================
    private static long generarNroFactura() {
        return CollectionFactura.facturas.size() + 1;
    }
}
