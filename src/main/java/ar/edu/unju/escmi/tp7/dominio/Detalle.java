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

    public int getCantidad() { return cantidad; }
    public double getImporte() { return importe; }
    public Producto getProducto() { return producto; }

    public double calcularImporte() {
        return producto.getPrecioUnitario() * cantidad;
    }

    @Override
    public String toString() {
        return "Detalle{producto=" + producto.getCodigo() + ", cantidad=" + cantidad + ", importe=" + importe + "}";
    }
}
