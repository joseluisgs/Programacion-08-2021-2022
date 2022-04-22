package es.joseluisgs.dam.models;

import es.joseluisgs.dam.utils.Formatter;

import java.time.LocalDateTime;
import java.util.List;

public class Acuerdo {
    private static int contador = 0;
    private final int id;
    private final String nombre;
    private final LocalDateTime fecha;
    private final List<LineaAcuerdo> lineas;

    public Acuerdo(String nombre, LocalDateTime fecha, List<LineaAcuerdo> lineas) {
        this.id = ++contador;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lineas = lineas;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        // Puedes imprimir listas como Arrays.toString(lista))
        return "Acuerdo{" + "id=" + id + ", nombre=" + nombre + ", fecha="
                + Formatter.dateParser(fecha) + ", lineas=" + lineas + '}';
    }
}
