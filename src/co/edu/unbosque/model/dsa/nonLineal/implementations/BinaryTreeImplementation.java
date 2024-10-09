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

    /*
    Method to validate whether the Binary Tree is empty or not:
    1) Return if root equals to Null.
     */
    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    /*
    Method to read the Binary Tree In Order:
    1) Validate if the Root Node is different to Null.
    A) If TRUE
    2) Call the recursive method (readInOrder) to read the Left Child Node.
    3) Print the Root Node.
    4) Call the recursive method (readInOrder) to read the Right Child Node.
    B) If FALSE
    5) Do nothing.

     */
    @Override
    public void readInOrder(TreeNode<T> root) {
        if(!(root == null)){
            readInOrder(root.leftChild);
            System.out.println(root);
            readInOrder(root.rightChild);
        }
    }

    /*
    Method to read the Binary Tree in Pre Order:
    1) Validate if the Root Node is different to Null.
    A) If TRUE
    2) Print the Root Node.
    3) Call the recursive method (readPreOrder) to read the Left Child Node.
    4) Call the recursive method (readPreOrder) to read the Right Child Node.
    B) If FALSE
    5) Do nothing.
     */
    @Override
    public void readPreOrder(TreeNode<T> root) {
        if(!(root == null)){
            System.out.println(root);
            readPreOrder(root.leftChild);
            readPreOrder(root.rightChild);
        }
    }

    /*
    Method to read the Binary Tree in Post Order:
    1) Validate if the Root Node is different to Null.
    A) If TRUE
    2) Call the recursive method (readPostOrder) to read the Left Child Node.
    3) Call the recursive method (readPostOrder) to read the Right Child Node.
    4) Print the Root Node.
    B) If FALSE
    5) Do nothing.
     */
    @Override
    public void readPostOrder(TreeNode<T> root) {
        if(!(root == null)){
            readPostOrder(root.leftChild);
            readPostOrder(root.rightChild);
            System.out.println(root);
        }
    }

    //Getters & Setters
    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }
}
