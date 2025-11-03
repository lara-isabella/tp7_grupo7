package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.Stock;
import ar.edu.unju.escmi.tp7.dominio.Producto;

public class CollectionStock {

    public static List<Stock> stocks = new ArrayList<Stock>();

    public static void precargarStocks() {
        if (stocks.isEmpty()) {
            // Carga manual de stock según los productos del catálogo
            Producto p1 = CollectionProducto.buscarProducto(1111);
            Producto p2 = CollectionProducto.buscarProducto(2111);
            Producto p3 = CollectionProducto.buscarProducto(3111);
            Producto p4 = CollectionProducto.buscarProducto(4111);
            Producto p5 = CollectionProducto.buscarProducto(5111);

            if (p1 != null) stocks.add(new Stock(p1, 5));
            if (p2 != null) stocks.add(new Stock(p2, 4));
            if (p3 != null) stocks.add(new Stock(p3, 3));
            if (p4 != null) stocks.add(new Stock(p4, 6));
            if (p5 != null) stocks.add(new Stock(p5, 2));
        }
    }

    public static void agregarStock(Stock stock) {
        try {
            stocks.add(stock);
        } catch (Exception e) {
            System.out.println("\nNO SE PUEDE GUARDAR EL STOCK");
        }
    }

    public static Stock buscarStock(Producto producto) {
        Stock stockEncontrado = null;
        try {
            for (Stock stock : stocks) {
                if (stock.getProducto().getCodigo() == producto.getCodigo()) {
                    stockEncontrado = stock;
                    break;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return stockEncontrado;
    }

    public static void reducirStock(Stock stock, int cantidad) {
        try {
            if (stock != null && stock.validarStockDisponible(cantidad)) {
                stock.actualizarStock(cantidad);
            } else {
                System.out.println("No hay suficiente stock disponible para esa cantidad.");
            }
        } catch (Exception e) {
            System.out.println("\nERROR AL REDUCIR STOCK");
        }
    }

    public static void mostrarStocks() {
        if (stocks.isEmpty()) {
            System.out.println("No hay registros de stock.");
        } else {
            for (Stock s : stocks) {
                System.out.println(s);
            }
        }
    }
}
