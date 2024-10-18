package co.edu.unbosque.model.dsa.nonLineal.interfaces;

import co.edu.unbosque.model.dsa.nonLineal.implementations.RedBlackTreeNode;

public interface IRedBlackBinaryTree <T extends Comparable<T>>{

    RedBlackTreeNode<T> insert(T value);

    void delete(T value);

    void traverseInOrder();

    void traversePreOrder();

    void traversePostOrder();

    T getMax();

    T getMin();

    boolean isEmpty();

}
