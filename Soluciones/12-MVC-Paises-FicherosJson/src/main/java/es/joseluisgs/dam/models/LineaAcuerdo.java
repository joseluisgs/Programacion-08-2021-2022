package es.joseluisgs.dam.models;

public class LineaAcuerdo {
    private final Pais pais;
    private final int año;

    public LineaAcuerdo(Pais pais, int año) {
        this.pais = pais;
        this.año = año;
    }

    @Override
    public String toString() {
        return "LineaAcuerdo{" + "pais=" + pais.getNombre() + ", año=" + año + '}';
    }
}
