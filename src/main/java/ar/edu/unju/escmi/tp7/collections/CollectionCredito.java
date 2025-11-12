package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.Credito;

public class CollectionCredito {

	public static List<Credito> creditos = new ArrayList<Credito>();

	public static void agregarCredito(Credito credito) {

		try {
			creditos.add(credito);
		} catch (Exception e) {
			System.out.println("\nNO SE PUEDE GUARDAR CREDITO");
		}

	}

	public static void buscarCreditoPorDni(long dni) {

		System.out.println("Buscar credito para dni: " + dni);

		boolean encontrado = false; 
		try {
			if (creditos != null && !creditos.isEmpty()) { 

				for (Credito credito : creditos) { 

					try {
						if (credito.getCliente() != null && credito.getCliente().getDni() == dni) {
							System.out.println("\n--- Crédito Encontrado ---");
							credito.mostrarCredito();
							encontrado = true;
						}
					} catch (NullPointerException e) {
						System.out.println(
								"ERROR: Se encontró un crédito incompleto (Cliente nulo). Se omite y se continúa la búsqueda.");
					}
				}
			}

			if (!encontrado) {
				System.out.println(" No se encontraron créditos asociados al DNI " + dni + ".");
			}

		} catch (Exception e) {
			System.out.println("ERROR durante la búsqueda de créditos: " + e.getMessage());
		}
	}
}