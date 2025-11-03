package ar.edu.unju.escmi.tp7.exceptions;
/*Se lanza cuando no hay suficiente stock disponible para realizar una venta.*/
public class StockNoSuficienteException extends Exception{
     public StockNoSuficienteException() {
        super("No hay suficiente stock disponible para realizar la venta. Por favor, verifique la cantidad solicitada.");
    }

    public StockNoSuficienteException(String mensaje) {
        super(mensaje);
    }

}
