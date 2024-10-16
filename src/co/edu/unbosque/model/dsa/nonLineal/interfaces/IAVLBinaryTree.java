package co.edu.unbosque.model.dsa.nonLineal.interfaces;

import co.edu.unbosque.model.dsa.nonLineal.implementations.AVLTreeNode;

public interface IAVLBinaryTree <T extends Comparable<T>> {

        AVLTreeNode<T> insert(T value);

        void delete(T value);

        void traverseInOrder();

        void traversePreOrder();

        void traversePostOrder();

        T getMax();

        T getMin();

        boolean isEmpty();
}
