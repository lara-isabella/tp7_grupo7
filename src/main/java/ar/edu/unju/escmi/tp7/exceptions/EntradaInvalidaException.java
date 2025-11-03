package ar.edu.unju.escmi.tp7.exceptions;
/*Se lanza cuando la entrada del usuario no cumple con el formato o tipo esperado.*/
public class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException() {
        super("La entrada proporcionada no es válida. Por favor, ingrese un valor correcto e intente nuevamente.");
    }

    public EntradaInvalidaException(String mensaje) {
        super(mensaje);
    }

}
