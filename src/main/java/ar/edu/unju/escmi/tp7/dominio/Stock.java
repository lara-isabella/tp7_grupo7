package ar.edu.unju.escmi.tp7.dominio;

public class Stock {
	private Integer cantidad;
	private Producto producto;

	public Stock() {
    }

    public Stock(Integer cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    public boolean validarStockDisponible (int cantidadSolicitada) {
        if (this.cantidad < cantidadSolicitada) {
            return false;
        }
        return true;
    }

    public void actualizarStock (int cantidadVendida) {
        if (cantidadVendida > this.cantidad) {
            System.out.println("No hay stock suficiente");
        }
        else {
            this.cantidad = this.cantidad - cantidadVendida;
        }
    }
}