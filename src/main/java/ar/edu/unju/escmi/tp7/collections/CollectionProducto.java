package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.Producto;

public class CollectionProducto {
     public static List<Producto> productos = new ArrayList<Producto>();

     public static void precargarProductos() {
          if (productos.isEmpty()) {
               productos = new ArrayList<Producto>();
               productos.add(new Producto(101, "Lavarropas Carga Frontal 8kg", 210000, "Argentina"));
               productos.add(new Producto(102, "Heladera No Frost 300L", 280000, "Argentina"));
               productos.add(new Producto(103, "Televisor LED 42\" Full HD", 150000, "China"));
               productos.add(new Producto(104, "Celular Smartphone 6.5\"", 190000, "Argentina"));
               productos.add(new Producto(105, "Aire Acondicionado 3000F", 250000, "Argentina"));
               productos.add(new Producto(106, "Notebook Core i5 8GB RAM", 450000, "China"));
               productos.add(new Producto(107, "Microondas 20L", 80000, "Argentina"));
               productos.add(new Producto(108, "Celular Gama Media 128GB", 220000, "Argentina"));
               productos.add(new Producto(109, "Televisor QLED 55\"", 350000, "Argentina"));
               productos.add(new Producto(110, "Lavarropas Carga Superior 7kg", 180000, "Argentina"));
          }
     }

     public static void guardarProducto(Producto producto) {
          
          try {
               if (productos.isEmpty()) {
                    productos.add(producto);
               } else {
                    long controlCodigo = producto.getCodigo();
                    boolean band = true;

                    for (Producto pro : productos) {
                         if (band) {
                              if (pro.getCodigo() == controlCodigo) {
                                   System.out.println("\nYa existe un producto con ese código");
                                   band = false;
                              }
                         }
                    }
                    if (band) {
                         productos.add(producto);
                    }

               }
          } catch (Exception e) {
               System.out.println("\nNo se pudo agregar el producto");
          }
          
     }

     public static Producto buscarProducto(long codigo) {
          Producto productoEncontrado = null;
          
          try {
               if (!productos.isEmpty()) {
                    for (Producto pro : productos) {
                         if (pro.getCodigo() == codigo) {
                              productoEncontrado = pro;
                         }
                    }
               }
          } catch (Exception e) {
               return null;
          }
          
          return productoEncontrado;
     }

     public static List<Producto> obtenerProductosA30() {
          List<Producto> productosAhora30 = new ArrayList<>();
          
          for (Producto p : productos) {
               if (p.getOrigenFabricacion().equals("Argentina")) {
                    String descripcion = p.getDescripcion().toLowerCase();
                    boolean califica = false;

                    if (descripcion.contains("celular") && p.getPrecioUnitario() <= 800000) {
                         califica = true;
                    }
                    else if (p.getPrecioUnitario() <= 1500000 && 
                              (descripcion.contains("aire") || 
                              descripcion.contains("heladera") || 
                              descripcion.contains("lavarropas") || 
                              descripcion.contains("tv") || 
                              descripcion.contains("televisor"))) {
                         califica = true;
                    }

                    if (califica) {
                         productosAhora30.add(p);
                    }
               }
          }
          
          return productosAhora30;
     }

     public static boolean buscarProductoA30 (long codigo) {
          List<Producto> productosAhora30 = obtenerProductosA30();
          
          for (Producto p : productosAhora30) {
               if (p.getCodigo() == codigo) {
                    return true;
               }
          }
          
          return false;
     }

     public static void mostrarProductosA30() {
          System.out.println("\n====== Lista de productos disponibles - Ahora 30 ======");
          CollectionStock.mostrarStockA30(obtenerProductosA30());
     }
}