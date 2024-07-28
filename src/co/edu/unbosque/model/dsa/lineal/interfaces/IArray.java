package co.edu.unbosque.model.dsa.lineal.interfaces;

public interface IArray <T> {

    void create(int index, T value);
    T read(int index);
    int read(T value);
    void update(int index, T value);
    void delete(int index);
    String readAll();

}
