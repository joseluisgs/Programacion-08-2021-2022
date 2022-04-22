package es.joseluisgs.dam.repositories;

import es.joseluisgs.dam.models.Acuerdo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcuerdoRepository implements IAcuerdoRepository {
    private final Map<Integer, Acuerdo> acuerdos = new HashMap<>();


    @Override
    public List<Acuerdo> findAll() {
        return new ArrayList<>(this.acuerdos.values());
    }

    @Override
    public Acuerdo findById(Integer id) {
        return this.acuerdos.get(id);
    }

    @Override
    public Acuerdo save(Acuerdo entity) {
        this.acuerdos.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Acuerdo update(Integer id, Acuerdo entity) {
        this.acuerdos.put(id, entity);
        return entity;
    }

    @Override
    public Acuerdo delete(Integer id) {
        return this.acuerdos.remove(id);
    }
}
