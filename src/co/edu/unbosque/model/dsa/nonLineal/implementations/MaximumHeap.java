package co.edu.unbosque.model.dsa.nonLineal.implementations;

public class MaximumHeap <T extends Comparable<T>> extends Heap<T>{


    protected void fixUpward(){
        int index = position;
        int parentIndex = (index - 1) / 2;
        //Condition: (If the parent is equal or greater than 0 ) AND (Child is greater than parent)
        while(parentIndex >= 0 && heap[index].compareTo(heap[parentIndex]) > 0){
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
        if(isEmpty()){
            return null;
        }
        T result = heap[0];
        //Change the last node to be the root.
        heap[0] = heap[position--];
        //Delete duplicate node (root - lastNode)
        heap[position + 1] = null;
        //Fix the elements to get the maximum to the top.
        fixDownward(position);
        return result;
    }

    private boolean isEmpty(){
        return (heap.length == 0);
    }

    @Override
    public void sort() {

    }
}
