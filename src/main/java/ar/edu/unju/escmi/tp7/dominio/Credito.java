package ar.edu.unju.escmi.tp7.dominio;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Credito {
    private Cliente cliente;
    private Producto producto;
    private TarjetaCredito tarjetaCredito;
    private List<Cuota> cuotas = new ArrayList<>();

    public Credito(Cliente cliente, Producto producto, TarjetaCredito tarjetaCredito) {
        this.cliente = cliente;
        this.producto = producto;
        this.tarjetaCredito = tarjetaCredito;
    }

    public boolean validarMonto() {
        return tarjetaCredito.tieneSaldoDisponible(producto.getPrecioUnitario());
    }

    public boolean validarTarjeta() {
        return tarjetaCredito != null;
    }

    public void generarCuotas() {
        double montoTotal = producto.getPrecioUnitario();
        double montoCuota = montoTotal / 30;
        LocalDate fecha = LocalDate.now();

        for (int i = 1; i <= 30; i++) {
            cuotas.add(new Cuota(i, montoCuota, fecha, fecha.plusMonths(i)));
        }
    }

    public void mostrarCredito() {
        System.out.println("Crédito del cliente: " + cliente);
        for (Cuota c : cuotas) {
            System.out.println(c);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Credito{" +
                "cliente=" + cliente +
                ", producto=" + producto +
                ", tarjetaCredito=" + tarjetaCredito +
                ", cuotas=" + cuotas.size() +
                '}';
    }
}
