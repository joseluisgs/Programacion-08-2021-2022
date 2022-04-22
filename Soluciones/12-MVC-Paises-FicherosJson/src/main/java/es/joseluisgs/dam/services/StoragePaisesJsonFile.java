package es.joseluisgs.dam.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import es.joseluisgs.dam.models.Pais;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StoragePaisesJsonFile implements IStoragePaises {
    private final Path currentRelativePath = Paths.get("");
    private final String ruta = currentRelativePath.toAbsolutePath().toString();
    private final String dir = ruta + File.separator + "data";
    private final String paisesFile = dir + File.separator + "paises.json";


    public StoragePaisesJsonFile() {
        init();
    }

    private void init() {
        Path path = Paths.get(dir);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public boolean save(List<Pais> lista) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        boolean result = false;
        PrintWriter f = null;
        try {
            f = new PrintWriter(new FileWriter(paisesFile));
            f.println(gson.toJson(lista));
            result = true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            result = false;
        } finally {
            if (f != null) {
                f.close();
            }
        }
        return result;
    }

    @Override
    public List<Pais> load() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Pais> lista = new ArrayList<>();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(paisesFile));
            // Dos opciones
            // Opcion A
            // var paises = gson.fromJson(reader, Pais[].class);
            // lista = List.of(paises);
            // Opcion B. Debe resolver los datos dinamicamente
            lista = gson.fromJson(reader, new TypeToken<List<Pais>>() {
            }.getType());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        return lista;
    }

    @Override
    public String getStoragePath() {
        return paisesFile;
    }
}
