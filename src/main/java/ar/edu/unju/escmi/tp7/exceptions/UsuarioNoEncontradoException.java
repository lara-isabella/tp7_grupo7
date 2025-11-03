package ar.edu.unju.escmi.tp7.exceptions;
/*Se lanza cuando no se encuentra un cliente con el DNI buscado.*/
public class UsuarioNoEncontradoException extends Exception {

    public UsuarioNoEncontradoException() {
        super("No se encontró ningún cliente con el DNI ingresado. Verifique los datos e intente nuevamente.");
    }

    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}

