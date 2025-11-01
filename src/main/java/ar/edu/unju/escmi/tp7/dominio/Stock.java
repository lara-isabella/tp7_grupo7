package ar.edu.unju.escmi.tp7.dominio;

public class Stock {
    private int cantidad;
    private Producto producto;

    public Stock() {
    }

    public Stock(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Verifica si hay stock suficiente para una cantidad solicitada.
     */
    public boolean hayStockDisponible(int cantidadSolicitada) {
        return cantidadSolicitada <= cantidad;
    }

    /**
     * Descuenta stock si hay suficiente. Devuelve true si se pudo descontar.
     */
    public boolean descontarStock(int cantidadSolicitada) {
        if (hayStockDisponible(cantidadSolicitada)) {
            cantidad -= cantidadSolicitada;
            return true;
        }
        return false;
    }

@Override
public String toString() {
    if (producto == null) {
        return "Producto no asignado | Stock disponible: " + cantidad;
    }

    return "Producto: " + producto.getDescripcion()
         + " | Origen: " + producto.getOrigenFabricacion()
         + " | Precio: $" + producto.getPrecioUnitario()
         + " | Stock disponible: " + cantidad;
}
}