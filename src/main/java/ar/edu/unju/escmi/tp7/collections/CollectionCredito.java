package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp7.dominio.Credito;

public class CollectionCredito {

    public static List<Credito> creditos = new ArrayList<>();

    public static void agregarCredito(Credito credito) {
        try {
            creditos.add(credito);
            System.out.println("Crédito registrado.");
        } catch (Exception e) {
            System.out.println("\nNO SE PUDO REGISTRAR EL CRÉDITO");
        }
    }

    public static Credito buscarCreditoPorDni(long dni) {
        Credito encontrado = null;
        try {
            for (Credito c : creditos) {
                if (c.getCliente().getDni() == dni) {
                    encontrado = c;
                    break;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return encontrado;
    }

    public static void mostrarCreditosCliente(long dni) {
        boolean hay = false;
        for (Credito c : creditos) {
            if (c.getCliente().getDni() == dni) {
                System.out.println(c);
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay créditos para el cliente con DNI " + dni);
    }
}
