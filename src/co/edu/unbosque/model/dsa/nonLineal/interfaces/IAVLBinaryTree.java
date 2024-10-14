package co.edu.unbosque.model.dsa.nonLineal.interfaces;

import co.edu.unbosque.model.dsa.nonLineal.implementations.AVLTreeNode;
import co.edu.unbosque.model.dsa.nonLineal.implementations.TreeNode;

public interface IAVLBinaryTree <T>{

        void createNode(T value);
        AVLTreeNode<T> readNode(T value, AVLTreeNode<T> root);
        boolean isEmpty();
        void readInOrder(AVLTreeNode<T> root);
        void readPreOrder(AVLTreeNode<T> root);
        void readPostOrder(AVLTreeNode<T> root);

}
