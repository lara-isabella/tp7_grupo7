package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Credito {

	private TarjetaCredito tarjetaCredito;
	private Factura factura;
	private List<Cuota> cuotas = new ArrayList<Cuota>();
	private Cliente cliente;
	private double totalCredito;

	public Credito() {
	}

	public Credito(TarjetaCredito tarjetaCredito, Factura factura, Cliente cliente, double totalCredito) {
		this.tarjetaCredito = tarjetaCredito;
		this.factura = factura;
		this.cliente = cliente;
		this.totalCredito = totalCredito;
	}

	public Credito(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public TarjetaCredito getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public List<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotalCredito() {
		return totalCredito;
	}

	public void setTotalCredito(double totalCredito) {
		this.totalCredito = totalCredito;
	}

	public void generarCuotas() {
		double totalCuota = this.factura.calcularTotalA30() / 30;
		int nroCuota = 0;
		LocalDate currentDate = LocalDate.now();
		LocalDate auxDate = LocalDate.now();

		for (int i = 0; i < 30; i++) {
			nroCuota++;
			Cuota cuota = new Cuota();
			cuota.setTotal(totalCuota);
			cuota.setNumCuota(nroCuota);
			cuota.setFechaGeneracion(currentDate);
			auxDate = auxDate.plusMonths(1);
			cuota.setFechaVencimiento(auxDate);
			cuotas.add(cuota);
		}

	}

	public void mostrarCredito() {
		System.out.println("***Tarjeta De Credito***" + tarjetaCredito + "\n" + factura + "\n\nCUOTAS:");
		for (Cuota cuota : cuotas) {
			System.out.println(cuota);
		}
	}

}