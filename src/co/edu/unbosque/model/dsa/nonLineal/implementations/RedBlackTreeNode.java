package co.edu.unbosque.model.dsa.nonLineal.implementations;

import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.RED;

public class RedBlackTreeNode <T extends Comparable<T>>{

    T value;
    Color color;
    RedBlackTreeNode<T> leftChild;
    RedBlackTreeNode<T> rightChild;
    RedBlackTreeNode<T> parent;


    public RedBlackTreeNode(T value){
        this.value = value;
        this.color = RED;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    public boolean isLeftChild(){
        return (this == parent.leftChild);
    }

    public void flipColor(){
        this.color = (color == RED)? (BLACK): (RED);
    }

    @Override
    public String toString(){
        return ("Node value: " + this.value + " Node color: " + ((this.color == RED)? ("Red"): ("Black")));
    }
}
