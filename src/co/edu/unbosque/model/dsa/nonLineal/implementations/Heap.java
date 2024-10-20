package co.edu.unbosque.model.dsa.nonLineal.implementations;

import co.edu.unbosque.model.dsa.nonLineal.interfaces.IHeap;

public abstract class Heap<T extends Comparable<T>> implements IHeap<T> {

    protected T[] heap;
    protected int position = -1;

    public Heap(){
        //Creation of a new comparable array to store type T objects. (It is a resizable array)
        heap = (T[]) new Comparable[2];
    }

    @Override
    public IHeap<T> insert(T data){
        if(isFull()){
             resize( 2 * heap.length);
        }
        heap[position++] = data;
        fixUpward();
        return this;
    }

    private boolean isFull(){
        return ((heap.length - 1) == position);
    }

    private void resize(int capacity){
        //Method System.arraycopy: Source array, Start position to copy form the source array, new Array to copy elements, Start position to copy elements in the new array, number of array elements to copy.
        System.arraycopy(heap,0,heap = (T[]) new Comparable[capacity], 0 , (position + 1));
    }

    protected abstract void fixUpward();

    protected abstract void fixDownward(int endIndex);

}
