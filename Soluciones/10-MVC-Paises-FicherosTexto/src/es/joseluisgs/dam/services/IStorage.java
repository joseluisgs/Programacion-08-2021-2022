package es.joseluisgs.dam.services;

public interface IStorage<T> {
    boolean save(T lista);

    T load();

    String getStoragePath();
}
