package co.edu.unbosque.model.dsa.nonLineal.implementations;

public class AVLTreeNode <T>{

    /*
    Every AVL Tree Node has 4 attributes:
    1) Value, representing the data to store.
    2) Left Child Node, representing the left child.
    3) Right Child Node, representing the right child.
    4) Balance factor, representing the node balance factor.
     */
    T value;
    AVLTreeNode<T> leftChild;
    AVLTreeNode<T> rightChild;
    int balanceFactor;

    /*
    Constructor: This one is used to create a AVL Tree Node from zero.
     */
    public AVLTreeNode(T value){
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.balanceFactor = 0;
    }

    /*
    ToString method overridden to show the node value and balance factor.
     */
    @Override
    public String toString(){
        return ("Node value: " + value + ". " + "Node balance factor: " + balanceFactor + ".");
    }

}
