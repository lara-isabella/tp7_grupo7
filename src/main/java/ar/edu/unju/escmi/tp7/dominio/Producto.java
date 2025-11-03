package modelo;

public class Producto {
    private long codigo;
    private String descripcion;
    private double precioUnitario;
    private String origenFabricacion;

    public Producto(long codigo, String descripcion, double precioUnitario, String origenFabricacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.origenFabricacion = origenFabricacion;
    }

    public long getCodigo() {
        return codigo;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", origenFabricacion='" + origenFabricacion + '\'' +
                '}';
    }
}
