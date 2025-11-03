package ar.edu.unju.escmi.tp7.dominio;

public class Detalle {
    private int cantidad;
    private double importe;
    private Producto producto;

    public Detalle(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.importe = calcularImporte();
    }

    public double calcularImporte() {
        return producto.getPrecioUnitario() * cantidad;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "cantidad=" + cantidad +
                ", importe=" + importe +
                ", producto=" + producto +
                '}';
    }
}
