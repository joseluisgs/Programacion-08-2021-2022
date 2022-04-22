package es.joseluisgs.dam.controllers;

import es.joseluisgs.dam.models.Acuerdo;
import es.joseluisgs.dam.models.LineaAcuerdo;
import es.joseluisgs.dam.models.Pais;
import es.joseluisgs.dam.repositories.IAcuerdoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AcuerdoController {
    private final IAcuerdoRepository acuerdosRepository;

    public AcuerdoController(IAcuerdoRepository acuerdosRepository) {
        this.acuerdosRepository = acuerdosRepository;
    }

    public Acuerdo crearAcuerdo(String nombre, String descripcion, List<Pais> paises) {
        List<LineaAcuerdo> lineas = new ArrayList<>();
        for (Pais pais : paises) {
            lineas.add(new LineaAcuerdo(pais, LocalDate.now().getYear()));
        }
        Acuerdo acuerdo = new Acuerdo(nombre, LocalDateTime.now(), lineas);
        return acuerdosRepository.save(acuerdo);
    }
}
