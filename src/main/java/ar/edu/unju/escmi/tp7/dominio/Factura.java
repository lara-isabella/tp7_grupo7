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

    public LocalDate getFecha() { return fecha; }
    public long getNroFactura() { return nroFactura; }
    public Cliente getCliente() { return cliente; }
    public List<Detalle> getDetalles() { return detalles; }

    public void agregarDetalle(Detalle d) {
        detalles.add(d);
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
        return "Factura{nro=" + nroFactura + ", fecha=" + fecha + ", cliente=" + cliente.getDni() + ", total=" + calcularTotal() + "}";
    }
}
