package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;

public class Cuota {
    private double monto;
    private int nroCuota;
    private LocalDate fechaGeneracion;
    private LocalDate fechaVencimiento;

    // 🔹 Constructor completo
    public Cuota(double monto, int nroCuota, LocalDate fechaGeneracion, LocalDate fechaVencimiento) {
        this.monto = monto;
        this.nroCuota = nroCuota;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaVencimiento = fechaVencimiento;
    }

    // 🔹 Getters y setters (opcionales)
    public double getMonto() { return monto; }
    public int getNroCuota() { return nroCuota; }
    public LocalDate getFechaGeneracion() { return fechaGeneracion; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }

    @Override
    public String toString() {
        return "Cuota [nroCuota=" + nroCuota + ", monto=" + monto +
               ", fechaGeneracion=" + fechaGeneracion +
               ", fechaVencimiento=" + fechaVencimiento + "]";
    }
}
