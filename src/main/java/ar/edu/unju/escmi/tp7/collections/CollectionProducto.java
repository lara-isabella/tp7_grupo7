package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp7.dominio.Producto;

public class CollectionProducto {

    public static List<Producto> productos = new ArrayList<>();

    public static void precargarProductos() {
        if (productos.isEmpty()) {
            productos.add(new Producto(1111L, "Aire Acondicionado Split On/Off 2750W FC Hisense", 220000, "Argentina"));
            productos.add(new Producto(2111L, "Celular Galaxy A33 Samsung", 150000, "Argentina"));
            productos.add(new Producto(3111L, "Lavarropas Next Drean", 190000, "Argentina"));
            productos.add(new Producto(4111L, "Televisor Smart TV 50\" Philips", 280000, "Argentina"));
        }
    }

    public static void agregarProducto(Producto producto) {
        try {
            productos.add(producto);
            System.out.println("Producto agregado.");
        } catch (Exception e) {
            System.out.println("\nNO SE PUEDE GUARDAR EL PRODUCTO");
        }
    }

    public static Producto buscarProducto(long codigo) {
        Producto productoEncontrado = null;
        try {
            for (Producto pro : productos) {
                if (pro.getCodigo() == codigo) {
                    productoEncontrado = pro;
                    break;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return productoEncontrado;
    }

    public static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }
}