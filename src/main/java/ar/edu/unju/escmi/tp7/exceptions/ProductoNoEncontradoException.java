package ar.edu.unju.escmi.tp7.exceptions;
/*Se lanza cuando no se encuentra el producto solicitado en el sistema.*/
public class ProductoNoEncontradoException extends Exception {
    public ProductoNoEncontradoException() {
        super("El producto solicitado no se encuentra registrado en el sistema.");
    }

    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
