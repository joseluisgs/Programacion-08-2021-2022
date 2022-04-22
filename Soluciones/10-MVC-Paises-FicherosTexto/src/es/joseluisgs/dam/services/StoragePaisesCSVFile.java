package es.joseluisgs.dam.services;

import es.joseluisgs.dam.models.Pais;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StoragePaisesCSVFile implements IStoragePaises {
    private final Path currentRelativePath = Paths.get("");
    private final String ruta = currentRelativePath.toAbsolutePath().toString();
    private final String dir = ruta + File.separator + "data";
    private final String paisesFile = dir + File.separator + "paises.txt";
    private final String fieldSeparator = ";";

    public StoragePaisesCSVFile() {
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
        PrintWriter f = null;
        boolean result = false;
        try {
            f = new PrintWriter(new FileWriter(paisesFile));

            for (var pais : lista) {
                f.println(pais.toString(fieldSeparator));
            }

            result = true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (f != null) {
                f.close();
            }
        }
        return result;
    }

    @Override
    public List<Pais> load() {
        File fichero;
        BufferedReader f = null;
        List<Pais> lista = new ArrayList<>();
        try {
            fichero = new File(paisesFile);
            f = new BufferedReader(new FileReader(fichero));

            String linea;
            while ((linea = f.readLine()) != null) {
                lista.add(getPais(linea));
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
        return lista;
    }

    private Pais getPais(String linea) {
        String[] campos = linea.split(fieldSeparator);
        return new Pais(
                Integer.parseInt(campos[0]),
                campos[1],
                campos[2],
                campos[3],
                campos[4],
                campos[5],
                Double.parseDouble(campos[6])
        );
    }

    @Override
    public String getStoragePath() {
        return paisesFile;
    }
}
