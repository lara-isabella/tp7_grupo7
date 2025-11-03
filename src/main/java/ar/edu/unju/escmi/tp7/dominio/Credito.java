package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Credito {

    private Cliente cliente;
    private Producto producto;
    private TarjetaCredito tarjetaCredito;
    private double monto;
    private List<Cuota> cuotas;

    // ===== CONSTRUCTORES =====
    public Credito(Cliente cliente, Producto producto, TarjetaCredito tarjetaCredito, double monto) {
        this.cliente = cliente;
        this.producto = producto;
        this.tarjetaCredito = tarjetaCredito;
        this.monto = monto;
        this.cuotas = new ArrayList<>();
    }

    // Constructor sin monto (permite crear y asignar después)
    public Credito(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.producto = producto;
        this.cuotas = new ArrayList<>();
        this.tarjetaCredito = (cliente != null) ? cliente.getTarjeta() : null;
    }

    // Constructor adicional para compatibilidad con tu Main
    public Credito(Cliente cliente, Producto producto, TarjetaCredito tarjetaCredito) {
        this.cliente = cliente;
        this.producto = producto;
        this.tarjetaCredito = tarjetaCredito;
        this.cuotas = new ArrayList<>();
    }

    // ===== MÉTODOS =====
    public boolean validarMonto() {
        // Validación del monto total contra el límite general de la tienda
        double limiteGeneral = 1500000.0;
        return producto != null && producto.getPrecioUnitario() <= limiteGeneral;
    }

    public boolean validarTarjeta() {
        // Verifica que exista tarjeta y que tenga saldo suficiente para cubrir el precio del producto
        if (tarjetaCredito == null) return false;
        return tarjetaCredito.tieneSaldoDisponible(producto.getPrecioUnitario());
    }

    public void generarCuotas(int cantidadCuotas) {
        double montoCuota = monto / cantidadCuotas;
        LocalDate fecha = LocalDate.now();

        for (int i = 1; i <= cantidadCuotas; i++) {
            LocalDate fechaVencimiento = fecha.plusMonths(i);
            cuotas.add(new Cuota(montoCuota, i, fecha, fechaVencimiento));
        }
    }

    // Sobrecarga para el Main (usa 12 por defecto)
    public void generarCuotas() {
        this.monto = producto.getPrecioUnitario();
        generarCuotas(12);
    }

    public void mostrarCredito() {
        System.out.println("=== Crédito generado ===");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Producto: " + producto.getDescripcion());
        System.out.println("Monto total: $" + monto);
        System.out.println("Tarjeta: " + tarjetaCredito.getNumero());
        System.out.println("Cantidad de cuotas: " + cuotas.size());
    }

    // ===== GETTERS Y SETTERS =====
    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public double getMonto() {
        return monto;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    @Override
    public String toString() {
        return "Credito{" +
                "cliente=" + cliente.getNombre() +
                ", producto=" + producto.getDescripcion() +
                ", monto=" + monto +
                ", tarjeta=" + (tarjetaCredito != null ? tarjetaCredito.getNumero() : "sin tarjeta") +
                '}';
    }
}
