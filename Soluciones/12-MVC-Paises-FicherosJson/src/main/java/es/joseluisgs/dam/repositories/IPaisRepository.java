package es.joseluisgs.dam.repositories;

import es.joseluisgs.dam.models.Pais;

// Toda nueva funcionalidad se extiende de la interfaz SOLID
public interface IPaisRepository extends CRUDRepository<Pais, Integer> {

    Pais findByNombre(String nombre);

    void clearAll();

}
