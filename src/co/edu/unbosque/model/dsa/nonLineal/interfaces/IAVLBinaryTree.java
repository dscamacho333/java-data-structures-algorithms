package co.edu.unbosque.model.dsa.nonLineal.interfaces;

import co.edu.unbosque.model.dsa.nonLineal.implementations.AVLTreeNode;

public interface IAVLBinaryTree <T>{


        AVLTreeNode<T> readNode(T value, AVLTreeNode<T> root);

}
