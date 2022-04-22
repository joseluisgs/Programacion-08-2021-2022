package es.joseluisgs.dam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Producto {
    private final String id = UUID.randomUUID().toString();
    private String nombre;
    private String descripcion;
    private double precio = Math.random() * 100;
}
