package ar.edu.unju.escmi.tp7.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.TarjetaCredito;

public class CollectionTarjetaCredito {

    public static List<TarjetaCredito> tarjetas = new ArrayList<TarjetaCredito>();

    public static void precargarTarjetas() {
        if (tarjetas.isEmpty()) {
            tarjetas = new ArrayList<TarjetaCredito>();
            tarjetas.add(new TarjetaCredito(123456789, LocalDate.of(2028, 6, 15), CollectionCliente.buscarCliente(47813412), 1200000));
            tarjetas.add(new TarjetaCredito(987654321, LocalDate.of(2029, 9, 22), CollectionCliente.buscarCliente(47718910), 1500000));
            tarjetas.add(new TarjetaCredito(555444333, LocalDate.of(2027, 2, 5), CollectionCliente.buscarCliente(47545205), 1350000));
        }
    }

    
    public static void agregarTarjetaCredito(TarjetaCredito tarjeta) {
        
        try {
            tarjetas.add(tarjeta);
        } catch (Exception e) {
            System.out.println("\nNO SE PUEDE GUARDAR LA TARJETA DE CREDITO");
        }
        
    }

    public static TarjetaCredito buscarTarjetaCredito(long numero) {
        TarjetaCredito tarjetaEncontrada = null;
        
        try {
            if (tarjetas != null) {
                for (TarjetaCredito tarjeta : tarjetas) {
                    if (tarjeta.getNumero() == numero) {
                        tarjetaEncontrada = tarjeta;
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        
        return tarjetaEncontrada;
    }
}