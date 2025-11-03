package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp7.dominio.Cliente;
import ar.edu.unju.escmi.tp7.dominio.TarjetaCredito;
import java.time.LocalDate;

public class CollectionCliente {

    public static List<Cliente> clientes = new ArrayList<>();

    public static void precargarClientes() {
        if (clientes.isEmpty()) {
            TarjetaCredito t1 = new TarjetaCredito(12345678L, LocalDate.of(2026,5,31),150000,150000);
            TarjetaCredito t2 = new TarjetaCredito(23456789L, LocalDate.of(2027,8,15),200000,200000);
            clientes.add(new Cliente(45111222L, "Mario Barca", "Alvear 120", "65454686", t1));
            clientes.add(new Cliente(36888666L, "Juan Perez", "Av. Belgrano 300", "35185695", t2));
            clientes.add(new Cliente(25777555L, "Ana Juarez", "Islas Malvinas 731", "38845224", t1));
        }
    }

    public static void agregarCliente(Cliente cliente) {
        try {
            clientes.add(cliente);
            System.out.println("Cliente agregado.");
        } catch (Exception e) {
            System.out.println("\nNO SE PUEDE GUARDAR EL CLIENTE");
        }
    }

    public static Cliente buscarCliente(long dni) {
        Cliente clienteEncontrado = null;
        try {
            for (Cliente cli : clientes) {
                if (cli.getDni() == dni) {
                    clienteEncontrado = cli;
                    break;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return clienteEncontrado;
    }
}
