package es.joseluisgs.dam.model;

import java.time.LocalDateTime;

public class Persona {
    private int id;
    private String nombre;
    private String email;
    private LocalDateTime createdAt;

    private static int contador = 0;

    public Persona(String nombre, String email) {
        this.id = ++contador;
        this.nombre = nombre;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }

    public Persona(int id, String nombre, String email, LocalDateTime createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", createdAt=" + createdAt + '}';
    }

    public String toFile() {
        return id + ";" + nombre + ";" + email + ";" + createdAt;
    }
}
