package es.joseluisgs.dam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Menu {
    private final String id = UUID.randomUUID().toString();
    private String nombre;
    private String descripcion;
    private double precio = 0.0;
    private List<Producto> productos;

    public Menu(String nombre, String descripcion, List<Producto> productos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = productos;
        this.precio = calcularPrecio();
    }

    private double calcularPrecio() {
        double precio = 0.0;
        for (Producto producto : productos) {
            precio += producto.getPrecio();
        }
        return precio;
    }
}

