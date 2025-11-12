package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.Cliente;

public class CollectionCliente {

	public static List<Cliente> clientes = new ArrayList<Cliente>();


    public static void precargarClientes() {
        if (clientes.isEmpty()) {
            clientes.add(new Cliente(47813412, "Lautaro Cari", "Almirante Brown 212", "38863398154"));
            clientes.add(new Cliente(47718910, "Bruno Fernandez", "Ramirez de Velasco 122", "3880321232"));
            clientes.add(new Cliente(47545205, "Tomas Obeide", "El Cardenal 528", "3886829012"));
        }
    }


    public static void agregarCliente(Cliente cliente) {
    	try {
    		clientes.add(cliente);
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
                }
            }
		} catch (Exception e) {
			return null;
		}
        
        return clienteEncontrado;
    }
}