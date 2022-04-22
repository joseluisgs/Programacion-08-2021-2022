package es.joseluisgs.dam;

import es.joseluisgs.dam.controllers.PersonaController;
import es.joseluisgs.dam.model.Persona;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // FicherosBinarios.testEscribirFicheroBinario();
        // FicherosBinarios.testLeerFicheroBinario();
        PersonaController pc = new PersonaController();
        pc.getDir();
        List<Persona> personas = List.of(
                new Persona("Juan", "juan@juan.es"),
                new Persona("Pepe", "pepe@pepe.es"),
                new Persona("Luis", "luis@luis.es")
        );
        pc.savePersonas1By1(personas, false);
        List<Persona> res = pc.readPersonas1By1();
        for (Persona p : res) {
            System.out.println(p);
        }

        pc.savePersonasList(personas, false);
        List<Persona> res2 = pc.readPersonasList();
        for (Persona p : res2) {
            System.out.println(p);
        }

        pc.backup();
    }
}
