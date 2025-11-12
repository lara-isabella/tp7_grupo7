package ar.edu.unju.escmi.tp7.dominio;

import java.time.LocalDate;

public class Cuota {

	 private double total;
	 private int numCuota;
	 private LocalDate fechaGeneracion;
	 private LocalDate fechaVencimiento;
	 private boolean estado; 

	 public Cuota() {

	 }

	 public Cuota(double total, int numCuota, LocalDate fechaGeneracion, LocalDate fechaVencimiento, boolean estado) {
	        this.total = total;
	        this.numCuota = numCuota;
	        this.fechaGeneracion = fechaGeneracion;
	        this.fechaVencimiento = fechaVencimiento;
			this.estado = estado;
	 }

	 public double getTotal() {
	        return total;
	 }

	 public void setTotal(double total) {
	        this.total = total;
	 }

	 public int getNumCuota() {
	        return numCuota;
	 }

	 public void setNumCuota(int numCuota) {
	        this.numCuota = numCuota;
	 }

	 public LocalDate getFechaGeneracion() {
	        return fechaGeneracion;
	 }

	 public void setFechaGeneracion(LocalDate fechaGeneracion) {
	        this.fechaGeneracion = fechaGeneracion;
	 }

	 public LocalDate getFechaVencimiento() {
	        return fechaVencimiento;
	 }

	 public void setFechaVencimiento(LocalDate fechaVencimiento) {
	        this.fechaVencimiento = fechaVencimiento;
	 }

	 public boolean isEstado() {
		 return estado;
	 }

	 public void setEstado(boolean estado) {
		 this.estado = estado;
	 }
	 

	 @Override
	public String toString() {
		return "Total: " + total + ", N° De Cuota:" + numCuota + ", Fecha De Generacion: " + fechaGeneracion
				+ ", Fecha De Vencimiento: " + fechaVencimiento + ", Estado: " + (estado? "PAGADO" : "PENDIENTE") + "\n";
	}

	 
	    
}