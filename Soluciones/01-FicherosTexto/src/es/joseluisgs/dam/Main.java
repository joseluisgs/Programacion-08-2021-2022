package es.joseluisgs.dam;

import es.joseluisgs.dam.controllers.PersonaController;
import es.joseluisgs.dam.model.Persona;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // FicherosTexto.testEscribirFicheroTexto();
        // FicherosTexto.testLeerFicheroTexto();
        PersonaController pc = new PersonaController();
        pc.getDir();
        List<Persona> personas = List.of(
               new Persona("Juan", "juan@juan.es"),
               new Persona("Pepe", "pepe@pepe.es"),
               new Persona("Luis", "luis@luis.es")
        );
        pc.savePersonas(personas, false);
        List<Persona> res = pc.readPersonas();
        for (Persona p : res) {
            System.out.println(p);
        }

        pc.backup();
    }
}
