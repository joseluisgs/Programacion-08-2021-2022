package es.joseluisgs.dam.model;

import es.joseluisgs.dam.utils.Formatter;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Persona implements Serializable {
    private static final long serialVersionUID = -87908723585899098L;
    private int id;
    private String nombre;
    private String email;
    private LocalDateTime createdAt;
    private Double salario;

    private static int contador = 0;

    public Persona(String nombre, String email) {
        this.id = ++contador;
        this.nombre = nombre;
        this.email = email;
        this.createdAt = LocalDateTime.now();
        this.salario = Math.random() * 100000;
    }

    public Persona(int id, String nombre, String email, LocalDateTime createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", createdAt=" + Formatter.dateParser(createdAt) + ", salario=" + Formatter.moneyParser(salario) + '}';
    }
}
