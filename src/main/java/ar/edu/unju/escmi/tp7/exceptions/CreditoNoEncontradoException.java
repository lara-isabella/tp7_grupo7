package ar.edu.unju.escmi.tp7.exceptions;
/*Se lanza cuando no se encuentra un crédito asociado al cliente.*/
public class CreditoNoEncontradoException extends Exception {
    public CreditoNoEncontradoException() {
        super("No se encontró ningún crédito asociado al cliente especificado.");
    }

    public CreditoNoEncontradoException(String mensaje) {
        super(mensaje);
    }

}
