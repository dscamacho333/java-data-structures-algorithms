package co.edu.unbosque.model.dsa.nonLineal.implementations;

public class MinimumHeap <T extends Comparable<T>> extends Heap<T>{

    protected void fixUpward(){
        int index = position;
        int parentIndex = (index - 1) / 2;
        //Condition: (If the parent is equal or greater than 0 ) AND (Child is greater than parent)
        while(parentIndex >= 0 && heap[index].compareTo(heap[parentIndex]) < 0){
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1)/2;
        }
    }

    @Override
    protected void fixDownward(int endIndex) {

    }

    protected void swap(int firstIndex, int secondIndex){
        //Simple switch variables values. Switch element at first index with element at second index.
        T temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }


    @Override
    public T getRoot() {
        return null;
    }

    @Override
    public void sort() {

    }
}
