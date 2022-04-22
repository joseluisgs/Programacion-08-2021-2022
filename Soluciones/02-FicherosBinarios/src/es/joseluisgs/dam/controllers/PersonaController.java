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
    private final String personasFile = dir + File.separator + "personas.dat";

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

    public void savePersonas1By1(List<Persona> personas, boolean append) {
        File fichero = null;
        ObjectOutputStream f = null;
        try {
            fichero = new File(personasFile);
            f = new ObjectOutputStream(new FileOutputStream(fichero, append));

            for (Persona p : personas) {
                f.writeObject(p);
            }

        } catch (Exception e) {
            System.out.println("Error Write: " + e.getMessage());
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    System.out.println("Error Close Write: " + e.getMessage());
                }
            }
        }
    }

    public List<Persona> readPersonas1By1() {
        File fichero = null;
        ObjectInputStream f = null;
        List<Persona> personas = new ArrayList<>();
        try {
            fichero = new File(personasFile);
            f = new ObjectInputStream(new FileInputStream(fichero));

            Persona persona;
            while ((persona = (Persona) f.readObject()) != null) {
                personas.add(persona);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error Read: " + e.getMessage());
        } catch (EOFException e) {
            // System.out.println("Fin de fichero");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    System.out.println("Error Close Read: " + e.getMessage());
                }
            }
        }
        return personas;
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

    public void savePersonasList(List<Persona> personas, boolean append) {
        File fichero = null;
        ObjectOutputStream f = null;
        try {
            fichero = new File(personasFile);
            f = new ObjectOutputStream(new FileOutputStream(fichero, append));

            f.writeObject(personas);

        } catch (Exception e) {
            System.out.println("Error Write: " + e.getMessage());
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    System.out.println("Error Close Write: " + e.getMessage());
                }
            }
        }
    }

    public List<Persona> readPersonasList() {
        File fichero = null;
        ObjectInputStream f = null;
        List<Persona> personas = new ArrayList<>();
        try {
            fichero = new File(personasFile);
            f = new ObjectInputStream(new FileInputStream(fichero));

            personas = (List<Persona>) f.readObject();

        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error Read: " + e.getMessage());
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    System.out.println("Error Close Read: " + e.getMessage());
                }
            }
        }
        return personas;
    }
}
