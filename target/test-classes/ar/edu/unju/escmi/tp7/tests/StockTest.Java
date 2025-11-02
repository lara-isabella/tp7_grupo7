package ar.edu.unju.escmi.poo.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ar.edu.unju.escmi.tp7.dominio.Producto;
import ar.edu.unju.escmi.tp7.dominio.Stock;

public class StockTest {

    @Test
    public void testDescuentoDeStockCorrecto() {
        Producto producto = new Producto(1L, "Heladera", 1200000, "Argentina");
        Stock stock = new Stock(10, producto);

        boolean resultado = stock.descontarStock(3);

        assertTrue(resultado, "El stock debería descontarse correctamente");
        assertEquals(7, stock.getCantidad(), "El stock restante debería ser 7");
    }

    @Test
    public void testDescuentoDeStockExcesivo() {
        Producto producto = new Producto(2L, "Celular", 700000, "Argentina");
        Stock stock = new Stock(5, producto);

        boolean resultado = stock.descontarStock(6);

        assertFalse(resultado, "No debería poder descontar más stock del disponible");
        assertEquals(5, stock.getCantidad(), "El stock debería permanecer en 5");
    }
}
