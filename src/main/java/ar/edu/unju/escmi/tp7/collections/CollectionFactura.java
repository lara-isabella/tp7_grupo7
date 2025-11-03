package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp7.dominio.Factura;

public class CollectionFactura {

    public static List<Factura> facturas = new ArrayList<>();

    public static void agregarFactura(Factura factura) {
        try {
            facturas.add(factura);
            System.out.println("Factura agregada.");
        } catch (Exception e) {
            System.out.println("\nNO SE PUDO GUARDAR LA FACTURA");
        }
    }

    public static Factura buscarFactura(long numero) {
        Factura facturaEncontrada = null;
        try {
            for (Factura f : facturas) {
                if (f.getNroFactura() == numero) {
                    facturaEncontrada = f;
                    break;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return facturaEncontrada;
    }

    public static void mostrarFacturasCliente(long dni) {
        boolean hay = false;
        for (Factura f : facturas) {
            if (f.getCliente().getDni() == dni) {
                System.out.println(f);
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay facturas para el cliente con DNI " + dni);
    }
}
