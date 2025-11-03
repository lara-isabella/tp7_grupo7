package ar.edu.unju.escmi.tp7.dominio;

public class Cliente {
    private long dni;
    private String nombre;
    private String direccion;
    private String telefono;
    private TarjetaCredito tarjeta;

    // Constructor completo según el diagrama
    public Cliente(long dni, String nombre, String direccion, String telefono, TarjetaCredito tarjeta) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tarjeta = tarjeta;
    }

    // Constructor alternativo (sin tarjeta, útil para pruebas)
    public Cliente(long dni, String nombre, String direccion, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y setters
    public long getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return "Cliente [DNI=" + dni + ", Nombre=" + nombre + ", Direccion=" + direccion +
               ", Telefono=" + telefono + ", Tarjeta=" + (tarjeta != null ? tarjeta.getNumero() : "Sin tarjeta") + "]";
    }
}
