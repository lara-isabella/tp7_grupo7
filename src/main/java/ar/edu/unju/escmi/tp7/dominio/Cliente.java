package modelo;

public class Cliente {
    private long dni;
    private String nombre;
    private String direccion;
    private String telefono;
    private TarjetaCredito tarjeta;

    public Cliente(long dni, String nombre, String direccion, String telefono, TarjetaCredito tarjeta) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tarjeta = tarjeta;
    }

    public long getDni() {
        return dni;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
