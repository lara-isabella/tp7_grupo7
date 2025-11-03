package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;

public class TarjetaCredito {

    private long numero;
    private LocalDate fechaCaducacion;
    private double limiteCompra;
    private double saldoDisponible;

    // ===== CONSTRUCTORES =====
    public TarjetaCredito(long numero, LocalDate fechaCaducacion, double limiteCompra, double saldoDisponible) {
        this.numero = numero;
        this.fechaCaducacion = fechaCaducacion;
        this.limiteCompra = limiteCompra;
        this.saldoDisponible = saldoDisponible;
    }

    // Constructor alternativo si no se especifica saldo
    public TarjetaCredito(long numero, LocalDate fechaCaducacion, double limiteCompra) {
        this.numero = numero;
        this.fechaCaducacion = fechaCaducacion;
        this.limiteCompra = limiteCompra;
        this.saldoDisponible = limiteCompra;
    }

    // ===== MÉTODOS =====
    public boolean tieneSaldoDisponible(double monto) {
        return saldoDisponible >= monto;
    }

    public void descontarCompra(double monto) {
        if (tieneSaldoDisponible(monto)) {
            saldoDisponible -= monto;
        } else {
            System.out.println("Saldo insuficiente en la tarjeta");
        }
    }

    public void mostrarTarjeta() {
        System.out.println("N° Tarjeta: " + numero +
                " | Caduca: " + fechaCaducacion +
                " | Límite: $" + limiteCompra +
                " | Disponible: $" + saldoDisponible);
    }

    // ===== GETTERS Y SETTERS =====
    public long getNumero() {
        return numero;
    }

    public LocalDate getFechaCaducacion() {
        return fechaCaducacion;
    }

    public double getLimiteCompra() {
        return limiteCompra;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "numero=" + numero +
                ", fechaCaducacion=" + fechaCaducacion +
                ", limiteCompra=" + limiteCompra +
                ", saldoDisponible=" + saldoDisponible +
                '}';
    }
}
