# Trabajo Práctico N.º 7 - Punto 3  
### **Respuestas teóricas**

---

### **a)** ¿Por qué no se dibuja la relación de agregación entre la clase `CollectionProducto` y `Producto`?

La razón por la que no parecen tener una relación explícita es que `CollectionProducto` posee un atributo `List<Producto>`.  
Por lo tanto, la colección ya representa la relación de manera **implícita**, y no es necesario mostrar la agregación gráficamente en el diagrama.

---

### **b)** ¿Cuántos atributos tiene la clase `Factura`? ¿Cuáles son los nombres de esos atributos?

La clase `Factura` tiene **cuatro atributos**:

| Atributo     | Tipo de dato | Descripción                                |
|---------------|---------------|---------------------------------------------|
| `fecha`       | `LocalDate`   | Fecha de emisión de la factura.             |
| `nroFactura`  | `long`        | Número identificador de la factura.         |
| `cliente`     | `Cliente`     | Cliente asociado a la factura.              |
| `detalles`    | `List<Detalle>` | Lista de objetos `Detalle` de la factura.   |

---

### **c)** ¿Cómo se llama la relación que se establece entre `Factura` y `Detalle`?

La relación entre las clases `Factura` y `Detalle` se llama composición, que sucede cuando una clase contiene objetos de otra clase.

---

### **d)** ¿Cómo se llama la relación entre las clases `Factura` y `Cliente`?

Entre las clases `Factura` y `Cliente` existe una relación de **asociación**,  
porque la clase `Factura` posee un atributo de tipo `Cliente`.

---

### **e)** ¿Por qué los atributos de las clases *Collections* son públicos?

Los atributos de las clases `Collections` son públicos por una cuestión de facilidad de acceso directo desde otras clases.

---

### **f)** Describa las características de todos los métodos de la clase `CollectionClientes`

La clase `CollectionClientes` tiene los siguientes métodos:

---

#### `1. agregarCliente(Cliente cliente)`
- **Visibilidad:** Público (+), es decir que cualquier otra clase puede usarla.
- **Parámetro:** `cliente` de tipo `Cliente`  
- **Función:** Agrega un objeto `Cliente` a la colección de clientes.  
- **Retorno:** Ninguno  

---

#### `2. buscarCliente(long dni)`
- **Visibilidad:** Pública (+)  
- **Parámetro:** `dni` de tipo `long`, usado para buscar al cliente.  
- **Función:** Busca un cliente dentro de la colección cuyo DNI coincida con el dado.  
- **Retorno:** Objeto `Cliente` si se encuentra  

---

#### `3. precargarClientes()`
- **Visibilidad:** Pública (+)  
- **Parámetros:** Ninguno  
- **Función:** Carga clientes predefinidos dentro de la colección (por ejemplo, datos de prueba o iniciales).  
- **Retorno:** Ninguno  

