package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.tp7.dominio.Producto;
import ar.edu.unju.escmi.tp7.dominio.Stock;

public class StockTest {

    @Test
    void testActualizarStockDecrementaCantidad() {
        Producto producto = new Producto(100L, "Producto Test", 1000.0, "Argentina");
        Stock stock = new Stock(10, producto);

        stock.actualizarStock(3);

        assertEquals(7, stock.getCantidad(), "El stock debe decrementarse en la cantidad vendida");
    }

}