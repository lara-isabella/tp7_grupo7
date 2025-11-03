package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;

public class Cuota {
    private double monto;
    private int nroCuota;
    private LocalDate fechaGeneracion;
    private LocalDate fechaVencimiento;

    public Cuota(int nroCuota, double monto, LocalDate fechaGeneracion, LocalDate fechaVencimiento) {
        this.nroCuota = nroCuota;
        this.monto = monto;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Cuota{" +
                "nroCuota=" + nroCuota +
                ", monto=" + monto +
                ", fechaGeneracion=" + fechaGeneracion +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }
}
