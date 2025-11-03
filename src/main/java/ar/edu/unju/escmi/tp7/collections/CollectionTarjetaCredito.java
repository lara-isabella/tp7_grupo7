package ar.edu.unju.escmi.tp7.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp7.dominio.TarjetaCredito;

public class CollectionTarjetaCredito {

    public static List<TarjetaCredito> tarjetas = new ArrayList<>();

    public static void precargarTarjetas() {
        if (tarjetas.isEmpty()) {
            tarjetas.add(new TarjetaCredito(12345678L, LocalDate.of(2026,5,31),150000,150000));
            tarjetas.add(new TarjetaCredito(23456789L, LocalDate.of(2027,8,15),200000,200000));
        }
    }

    public static void agregarTarjeta(TarjetaCredito tarjeta) {
        try {
            tarjetas.add(tarjeta);
            System.out.println("Tarjeta agregada.");
        } catch (Exception e) {
            System.out.println("\nNO SE PUDO GUARDAR LA TARJETA");
        }
    }

    public static TarjetaCredito buscarTarjeta(long numero) {
        TarjetaCredito encontrada = null;
        try {
            for (TarjetaCredito t : tarjetas) {
                if (t.getNumero() == numero) {
                    encontrada = t;
                    break;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return encontrada;
    }
}