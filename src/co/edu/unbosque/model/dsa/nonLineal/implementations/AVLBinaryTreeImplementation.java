package co.edu.unbosque.model.dsa.nonLineal.implementations;

import co.edu.unbosque.model.dsa.nonLineal.interfaces.IAVLBinaryTree;

public class AVLBinaryTreeImplementation <T extends Comparable<T>> implements IAVLBinaryTree<T> {

    /*
    Every AVL Tree Node has 1 attribute:
    1) Root, representing the tree root.
     */
    private AVLTreeNode<T> root;

    /*
    Constructor: This one is used to create an AVL Binary Tree from zero.
     */
    public AVLBinaryTreeImplementation(){
        this.root = null;
    }


    /*
    Method to read a node:
    1) Validate if the root points to null.
    A) If TRUE
    2) Return null.
    3) Validate if the root value equals the given value.
    C) If TRUE
    4) Return the root node.
    5) Validate if the given value is less than the root value.
    D) If TRUE
    6) Return the recursive call of the method passing the left child of the root as parameter.
    B) If FALSE
    7) Return the recursive call of the method passing the right child of the root as parameter.
     */
    @Override
    public AVLTreeNode<T> readNode(T value, AVLTreeNode<T> root) {
        if((root == null)){
            return null;
        }else if((root.value == value)){
            return root;
        }else if((value.compareTo(root.value) < 0)){
            return (readNode(value,root.leftChild));
        }else{
            return (readNode(value, root.rightChild));
        }
    }

    /*
    Method to get the Node balance factor:
    1) Validate if the given node equals to null.
    A) If TRUE
    2) Return -1 value, indicating it does not exist.
    B) If FALSE
    3) Return the AVL Tree Node balance factor attribute.
     */
    public int getBalanceFactor(AVLTreeNode<T> AVLTreeNode) {
        if((AVLTreeNode == null)){
            return -1;
        }else{
            return (AVLTreeNode.balanceFactor);
        }
    }

    /*
    Method to rotate to the left:
    1) Create and aux variable and point it to the left child of the given node .
    2) Point the left child of the given node to the right child of the aux node.
    3) Point the right child of the aux node to the given tree node.
    4) Set the value of the given tree node to the result of calling the getMaxNodeBalanceFactor() method.
    5) Set the value of the aux tree node to the result of calling the getMaxNodeBalanceFactor() method.
    6) Return the aux tree node.
     */
    public AVLTreeNode<T> leftRotation(AVLTreeNode<T> AVLTreeNode) {
        AVLTreeNode<T> aux = AVLTreeNode.leftChild;
        AVLTreeNode.leftChild = aux.rightChild;
        aux.rightChild = AVLTreeNode;
        AVLTreeNode.balanceFactor = getMaxNodeBalanceFactor(AVLTreeNode);
        aux.balanceFactor = getMaxNodeBalanceFactor(aux);
        return aux;
    }

    /*
    Method to rotate to the right:
    1) Create and aux variable and point it to the right child of the given node .
    2) Point the right child of the given node to the left child of the aux node.
    3) Point the left child of the aux node to the given tree node.
    4) Set the value of the given tree node to the result of calling the getMaxNodeBalanceFactor() method.
    5) Set the value of the aux tree node to the result of calling the getMaxNodeBalanceFactor() method.
    6) Return the aux tree node.
     */
    public AVLTreeNode<T> rightRotation(AVLTreeNode<T> AVLTreeNode) {
        AVLTreeNode<T> aux = AVLTreeNode.rightChild;
        AVLTreeNode.rightChild = aux.leftChild;
        aux.leftChild = AVLTreeNode;
        AVLTreeNode.balanceFactor = getMaxNodeBalanceFactor(AVLTreeNode);
        aux.balanceFactor = getMaxNodeBalanceFactor(aux);
        return aux;
    }

    /*
    Method to do a right-left rotation:
    1) Create an aux tree node.
    2) Point the left child of the given tree node to the result of rotating the same node to the right.
    3) Point aux node to given tree node rotated to the left.
    4) Return aux node.
     */
    public AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> AVLTreeNode) {
        AVLTreeNode aux;
        AVLTreeNode.leftChild = rightRotation(AVLTreeNode.leftChild);
        aux = leftRotation(AVLTreeNode);
        return aux;
    }

    /*
    Method to do a left-right rotation:
    1) Create an aux tree node.
    2) Point the right child of the given tree node to the result of rotating the same node to the left.
    3) Point aux node to given tree node rotated to the right.
    4) Return aux node.
     */
    public AVLTreeNode<T> leftrightRotation(AVLTreeNode<T> AVLTreeNode) {
        AVLTreeNode aux;
        AVLTreeNode.rightChild =  leftRotation(AVLTreeNode.rightChild);
        aux = rightRotation(AVLTreeNode);
        return aux;
    }

    /*
    Method to get the Max between 2 different balance factors:
    1) Return the result of calling the Math.max method being A the balance factor of the left child and being B the balance factor of the right child, to this add 1.
     */
    public int getMaxNodeBalanceFactor(AVLTreeNode<T> AVLTreeNode){
         return  (
                 Math
                            .max
                             (
                                     getBalanceFactor(AVLTreeNode.leftChild),
                                     getBalanceFactor(AVLTreeNode.rightChild)
                             )
                 + 1
                 );
    }



}
