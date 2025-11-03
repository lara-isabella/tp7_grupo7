package ar.edu.unju.escmi.tp7.dominio;

public class Stock {
    private int cantidad;

    public Stock(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean validarStockDisponible() {
        return cantidad > 0;
    }

    public void actualizarStock() {
        if (cantidad > 0) {
            cantidad--;
        }
    }

    @Override
    public String toString() {
        return "Stock{" +
                "cantidad=" + cantidad +
                '}';
    }
}