package modelo;

import java.time.LocalDate;

public class TarjetaCredito {
    private long numero;
    private LocalDate fechaCaducacion;
    private double limiteCompra;
    private double saldoDisponible;

    public TarjetaCredito(long numero, LocalDate fechaCaducacion, double limiteCompra, double saldoDisponible) {
        this.numero = numero;
        this.fechaCaducacion = fechaCaducacion;
        this.limiteCompra = limiteCompra;
        this.saldoDisponible = saldoDisponible;
    }

    public boolean tieneSaldoDisponible(double monto) {
        return saldoDisponible >= monto;
    }

    public void descontarCompra(double monto) {
        if (tieneSaldoDisponible(monto)) {
            saldoDisponible -= monto;
        }
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "numero=" + numero +
                ", limiteCompra=" + limiteCompra +
                ", saldoDisponible=" + saldoDisponible +
                '}';
    }
}
