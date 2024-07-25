package co.edu.unbosque.model.dsa.lineal.implementations;

import co.edu.unbosque.model.dsa.lineal.interfaces.IArray;

public class ArrayImplementation <T> implements IArray<T> {

    private T type;
    private int size;
    private T[] array;

    public ArrayImplementation(int size) {
        this.size = size;
        array = (T[]) new Object[size];
    }

    @Override
    public void create(int index, T value) {
        if(array[index] == null){
            array[index] = value;
        }
        else{
            //Working on it!
        }
    }

    @Override
    public T read(int index) {
        return array[index];
    }

    public int read(T value){
        int index = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(value)){
                index = i;
            }
        }
        return index;
    }

    @Override
    public void update(int index, T value) {
        array[index] = value;
    }

    @Override
    public void delete(int index) {
        array[index] = null;
        System.out.println("Working on it");
    }

    @Override
    public String readAll() {
        String content = "";
        for(int i = 0; i < array.length; i++) {
            content += array[i] + "\n";
        }
        return content;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }
}
