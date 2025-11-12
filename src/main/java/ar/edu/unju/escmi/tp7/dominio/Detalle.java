package ar.edu.unju.escmi.tp7.dominio;

public class Detalle {

	private int cantidad;
    private double importe;
    private Producto producto;
    private boolean estadoA30; 

    public Detalle() {

    }

    public Detalle(int cantidad, double importe, Producto producto, boolean estadoA30) {
        this.cantidad = cantidad;
        this.importe = importe;
        this.producto = producto;
        this.estadoA30 = estadoA30;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isEstadoA30() {
        return estadoA30;
    }

    public void setEstadoA30(boolean estadoA30) {
        this.estadoA30 = estadoA30;
    }

    @Override
    public String toString() {
        return "--- PRODUCTO ---" + producto + 
            "\nCANTIDAD: " + cantidad +
            "\nIMPORTE: $" + importe + 
            "\n" + (estadoA30 ? "PERTENECE AL PROGRAMA AHORA 30" : "PRODUCTO NORMAL");
    }

    
}