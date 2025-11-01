package ar.edu.unju.escmi.tp7.dominio;

public class Credito {
    private Cliente cliente;
    private Producto producto;

    public Credito() {
    }

    public Credito(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean validarMonto() {
        double limite = producto.getDescripcion().equalsIgnoreCase("Celular") ? 800000 : 1500000;
        return producto.getPrecioUnitario() <= limite;
    }

    public boolean validarTarjeta() {
        return cliente.getTarjeta().getLimiteCompra() >= producto.getPrecioUnitario();
    }
}
