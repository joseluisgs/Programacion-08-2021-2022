package es.joseluisgs.dam.controllers;

import es.joseluisgs.dam.model.Persona;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonaController {
    private Path currentRelativePath = Paths.get("");
    private String ruta = currentRelativePath.toAbsolutePath().toString();
    private final String dir = ruta + File.separator + "data";
    private final String backup = ruta + File.separator + "backup";
    private final String personasFile = dir + File.separator + "personas.txt";

    public PersonaController() {
        init();
    }

    private void init() {
        File directory = new File(this.dir);
        if (!directory.exists()) {
            directory.mkdir();
        }

        Path path = Paths.get(dir);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void getDir() {
        System.out.println(dir);
    }

    public void savePersonas(List<Persona> personas, boolean append) {
        File fichero = null;
        PrintWriter f = null;
        try {
            fichero = new File(personasFile);
            f = new PrintWriter(new FileWriter(personasFile,append));

            for (Persona p : personas) {
                f.println(p.toFile());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (f != null) {
                f.close();
            }
        }
    }

    public List<Persona> readPersonas() {
        File fichero = null;
        BufferedReader f = null;
        List<Persona> personas = new ArrayList<>();
        try {
            fichero = new File(personasFile);
            f = new BufferedReader(new FileReader(fichero));

            String linea;
            while ((linea = f.readLine()) != null) {
                personas.add(getPersona(linea));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        return personas;
    }

    private Persona getPersona(String linea) {
        String[] campos = linea.split(";");
        var id = Integer.parseInt(campos[0]);
        var nombre = campos[1];
        var email = campos[2];
        var createdAt = LocalDateTime.parse(campos[3]);
        var p = new Persona(id, nombre, email, createdAt);
        // System.out.println(p);
        return p;
    }


    public void backup() {
        Path pathOrigen = Paths.get(personasFile);
        Path pathFinal = Paths.get(backup + File.separator + "personas.bak");
        if (!Files.exists(Paths.get(backup))) {
            try {
                Files.createDirectories(Paths.get(backup));
                Files.copy(pathOrigen, pathFinal);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
