package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private LocalDate fecha;
    private long nroFactura;
    private Cliente cliente;
    private List<Detalle> detalles = new ArrayList<>();

    public Factura(LocalDate fecha, long nroFactura, Cliente cliente) {
        this.fecha = fecha;
        this.nroFactura = nroFactura;
        this.cliente = cliente;
    }

    public void agregarDetalle(Detalle detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {
        double total = 0;
        for (Detalle d : detalles) {
            total += d.calcularImporte();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "fecha=" + fecha +
                ", nroFactura=" + nroFactura +
                ", cliente=" + cliente +
                ", total=" + calcularTotal() +
                '}';
    }
}
