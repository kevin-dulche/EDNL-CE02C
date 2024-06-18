/*
 * Sección 1: Tablas Hash
 * Catálogo de productos
    Crear un programa que gestione un catálogo de productos utilizando una tabla HashMap. El programa debe permitir al usuario:
    Agregar nuevos productos al catálogo (con nombre, código, precio y descripción).
    Buscar un producto por nombre, código o descripción.
    Editar la información de un producto.
    Eliminar un producto del catálogo.
    Mostrar una lista de todos los productos del catálogo ordenados por diferentes criterios (nombre, código, precio).
 */

import java.util.HashMap;

public class TablasHash {
    public static void main(String[] args) {
        HashMap<String, Producto> catalogo = new HashMap<>();
        catalogo.put("1", new Producto("1", "Producto 1", 100, "Descripcion 1"));
        catalogo.put("2", new Producto("2", "Producto 2", 200, "Descripcion 2"));
        catalogo.put("3", new Producto("3", "Producto 3", 300, "Descripcion 3"));
        catalogo.put("4", new Producto("4", "Producto 4", 400, "Descripcion 4"));
        catalogo.put("5", new Producto("5", "Producto 5", 500, "Descripcion 5"));

        System.out.println("Catalogo de productos:");
        for (Producto producto : catalogo.values()) {
            System.out.println(producto);
        }

        System.out.println("\nBuscando producto por codigo 3:");
        for (Producto producto : catalogo.values()) {
            if (producto.getCodigo().equals("3")) {
                System.out.println(producto);
            }
        }

        System.out.println("\nBuscando producto por nombre Producto 2:");
        for (Producto producto : catalogo.values()) {
            if (producto.getNombre().equals("Producto 2")) {
                System.out.println(producto);
            }
        }

        System.out.println("\nBuscando producto por descripcion Descripcion 4:");
        for (Producto producto : catalogo.values()) {
            if (producto.getDescripcion().equals("Descripcion 4")) {
                System.out.println(producto);
            }
        }

        System.out.println("\nEditando producto con codigo 3:");
        catalogo.put("3", new Producto("3", "Producto 3 editado", 300, "Descripción 3 editada"));
        System.out.println(catalogo.get("3"));

        System.out.println("\nEliminando producto con codigo 2:");
        catalogo.remove("2");
        
        for (Producto producto : catalogo.values()) {
            System.out.println(producto);
        }
    }
}