package ar.edu.unju.escmi.tp7.dominio;

public class Stock {
    private Producto producto;
    private int cantidad;

    public Stock(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean validarStockDisponible(int cantidadSolicitada) {
        return cantidadSolicitada <= cantidad;
    }

    public void actualizarStock(int cantidadVendida) {
        if (cantidadVendida <= cantidad) {
            cantidad -= cantidadVendida;
        }
    }

    @Override
    public String toString() {
        return "Producto: " + producto.getDescripcion() + " | Cantidad disponible: " + cantidad;
    }
}
