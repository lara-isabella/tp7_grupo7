package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Factura {

	private static int cont = 1;
    private LocalDate fecha;
    private long numFactura;
    private Cliente cliente;
    private List<Detalle> detalles = new ArrayList<Detalle>();

    public Factura() {

    }

    public Factura(LocalDate fecha, Cliente cliente) {
        this.fecha = fecha;
        this.numFactura = cont ++;
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public long getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(long numFactura) {
        this.numFactura = numFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    public void agregarDetalle(Detalle detalle) {
        this.detalles.add(detalle);
    }

    public double calcularTotalA30() {
        double totalA30 = 0;
        for (Detalle detalle : detalles) {
            if (detalle.isEstadoA30()) {
                totalA30 += detalle.getImporte();
            }
        }
        return totalA30;
    }

        @Override
    public String toString() {
        return  "\n\n******************** Factura ********************"
                + "\nFecha: " + fecha + "\nN° de Factura: " + numFactura
                + "\nCliente: " + cliente.getNombre() + "\nDNI: " + cliente.getDni()
                + "\n************ Detalles de la Factura *************"
                + "\n" + detalles.toString().replaceAll("\\[|\\]", "").replaceAll(", ", "") + "\n"
                + (esFacturaA30() ? "\nTotal Ahora 30: $" + calcularTotalA30() 
                + "\nTotal de cada couta fija: " + calcularTotalA30()/30 : "Subtotal: $" + calcularTotal())
                + "\nTotal: $" + (calcularTotal() + calcularTotalA30());

    }

    public double calcularTotal() {
        double total = 0;
        for (Detalle detalle : detalles) {
            if (!detalle.isEstadoA30()) {
                total += detalle.getImporte();
            }
        }
        return total;
    }

    public boolean esFacturaA30() {
        for (Detalle detalle : detalles) {
            if (detalle.isEstadoA30()) {
                return true;
            }
        }
        return false;
    }


}