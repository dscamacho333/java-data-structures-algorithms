package co.edu.unbosque.model.dsa.nonLineal.implementations;

import co.edu.unbosque.model.dsa.nonLineal.interfaces.IBinaryTree;

//T extends Comparable<T> is used to indicate that the Binary Tree can only accept Abstract Data Types that implement the Comparable Java interface.
public class BinaryTreeImplementation <T extends Comparable<T>> implements IBinaryTree<T> {

    /*
    Every Binary Tree has one attribute:
    1) Root, representing the Root of the tree. (Pointer to the First Binary Tree Node)
     */
    private TreeNode<T> root;

    /*
    Constructor: This one is used to create a new Binary Tree from zero.
     */
    public BinaryTreeImplementation(){
        this.root = null;
    }

    /*
    Method to add a Tree Node to the Binary Tree:
    1) Create a new Tree Node with the value and the name parameters.
    2) Validate if the Binary tree is different to null.
    A) If TRUE (Binary tree ain´t empty)
    3) Create an aux Node pointing to the root.
    4) Create a parent Node.
    5) Iterate using a while loop-
    6) Point parent Node to aux Node.
    7) Validate if the value received as a parameter is less than the Node value.
    C) If TRUE (Parameter value is less than aux value)
    8) Point aux to the aux Node left Child.
    9) Validate if aux Node equals to Null.
    E) If TRUE
    10) Point parent Node left child node to new Tree Node.
    11) Return (Used to exit the method).
    F) If FALSE
    12) Do nothing.
    D) If FALSE (Parameter value is greater than aux value)
    13) Point aux to the aux right child Node.
    14) Validate if aux node equals null.
    G) If TRUE
    15) Point parent Node right child node to new Tree Node.
    16) Return (Used to exit the method).
    H) If FALSE
    17) Do nothing.
    B) If FALSE (Binary Tree is empty)
    18) Point root to the new Tree Node.
     */
    @Override
    public void createNode(T value, String name) {
        TreeNode<T> newTreeNode = new TreeNode<>(value, name);
        if(!(root == null)){
            TreeNode<T> aux = root;
            TreeNode<T> parent;
            while(true){
                parent = aux;
                if( value.compareTo(aux.value) < 0 ){
                    aux = aux.leftChild;
                    if(aux == null){
                        parent.leftChild = newTreeNode;
                        return;
                    }
                }else{
                    aux = aux.rightChild;
                    if(aux == null){
                        parent.rightChild = newTreeNode;
                        return;
                    }
                }
            }
        }else{
            root = newTreeNode;
        }
    }

    /*
    Method to create a Node only with the value:
    1) Call the CreateNode method, pass the value parameter and set the name parameter to Null.
     */
    @Override
    public void createNode(T value) {
        createNode(value,null);
    }
}
