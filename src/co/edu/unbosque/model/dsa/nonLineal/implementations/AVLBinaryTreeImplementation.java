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
    Method to create a Node:
    1) Create a new Node holding the given value.
    2) Validate if the root equals to null.
    A) If TRUE
    3) Point root to the new Node.
    B) If FALSE
    4) Point root to the AVL returned by the createAVLNode method.
     */
    @Override
    public void createNode(T value) {
        AVLTreeNode<T> newNode = new AVLTreeNode<>(value);
        if(root == null){
            root = newNode;
        }else{
            root = createAVLNode(newNode, root);
        }
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
    public void readInOrder(AVLTreeNode<T> root) {
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
    public void readPreOrder(AVLTreeNode<T> root) {
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
    public void readPostOrder(AVLTreeNode<T> root) {
        if(!(root == null)){
            readPostOrder(root.leftChild);
            readPostOrder(root.rightChild);
            System.out.println(root);
        }
    }

    /*
     Method to create an AVL Node and keep the tree balanced:
     1) Create an aux node pointing to the subTree node.
     2) Validate if the new node value is less than the subTree.
     A) If True
     3) Point the new parent to the result of balancing the tree to the left method.
     4) Validate if the new node value is greater than the subTree.
     B) If True
     5) Point the new parent to the result of balancing the tree to the right method.
     C) If FALSE
     6) Point new parent to null.
     -OUT OF THE CONDITIONALS-
     7) Call the update balance factor method.
     8) Return new parent variable.
     */
    public AVLTreeNode<T> createAVLNode(AVLTreeNode<T> newNode, AVLTreeNode<T> subTree) {
        AVLTreeNode<T> newParent = subTree;
        if(newNode.value.compareTo(subTree.value) < 0){

            newParent = balanceLeft(newNode,subTree, newParent);

        }else if(newNode.value.compareTo(subTree.value) > 0){

            newParent = balanceRight(newNode,subTree, newParent);

        }else{
            newParent = null;
        }
        updateBalanceFactor(subTree);
        return newParent;
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
    1) Create and aux variable and point it to the right child of the given node.
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
    public AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> AVLTreeNode) {
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

    /*
    Method to balance the tree to the right:
    1) Validate if the right child of the subtree equals to null.
    A) If TRUE
    2) Point the right child of the subtree to the new node.
    B) If FALSE
    3) point the right child of the subtree to the result of calling the createAVLNode method.
    4) Validate if the difference between the right child and left child balance factors equals two.
    C) If TRUE
    5) Validate if the new node value is greater than the left child value of the subtree.
    E) If TRUE
    6) Point new parent to the result of right rotating the tree.
    F) If FALSE
    7) Point new parent to the result of left rotating the tree.
    D) If FALSE
    8) Do nothing.
    -OUT OF THE CONDITIONALS-
    9) Return the new parent node.
     */
    public AVLTreeNode<T> balanceRight(AVLTreeNode<T> newNode, AVLTreeNode<T> subTree,AVLTreeNode<T> newParent){

        if(subTree.rightChild == null){
            subTree.rightChild = newNode;
        }else{
            subTree.rightChild = createAVLNode(newNode, subTree.rightChild);
            if((getBalanceFactor(subTree.rightChild) - getBalanceFactor(subTree.leftChild)) == 2){
                if(newNode.value.compareTo(subTree.leftChild.value) > 0){
                    newParent = rightRotation(subTree);
                }else{
                    newParent = rightLeftRotation(subTree);
                }
            }
        }
        return newParent;
    }

    /*
    Method to balance the tree to the left:
    1) Validate if the left child of the subtree equals to null.
    A) If TRUE
    2) Point the left child of the subtree to the new node.
    B) If FALSE
    3) point the left child of the subtree to the result of calling the createAVLNode method.
    4) Validate if the difference between the left child and right child balance factors equals two.
    C) If TRUE
    5) Validate if teh new node value is lesser than the left child value of the subtree.
    E) If TRUE
    6) Point new parent to the result of left rotating the tree.
    F) If FALSE
    7) Point new parent to the result of right rotating the tree.
    D) If FALSE
    8) Do nothing.
    -OUT OF THE CONDITIONALS-
    9) Return the new parent node.
     */
    public AVLTreeNode<T> balanceLeft(AVLTreeNode<T> newNode, AVLTreeNode<T> subTree, AVLTreeNode<T> newParent){

        if(subTree.leftChild == null){
            subTree.leftChild = newNode;
        }else{
            subTree.leftChild = createAVLNode(newNode, subTree.leftChild);
            if((getBalanceFactor(subTree.leftChild) - getBalanceFactor(subTree.rightChild)) == 2){
                if(newNode.value.compareTo(subTree.leftChild.value) < 0){
                    newParent = leftRotation(subTree);
                }else{
                    newParent = leftRightRotation(subTree);
                }
            }
        }
        return newParent;
    }

    /*
    Method to update the tree´s balance factor:
    1) Validate if the left child node of the subtree node is null AND the right child node is not.
    A) If TRUE
    2) Set the subtree balance factor to the result of the subtree´s right child node balance factor plus 1.
    3) Validate if the right child node of the subtree node is null AND the left child node is not.
    B) If TRUE
    4) Set the subtree balance factor to the result of the subtree´s left child node balance factor plus 1.
    C) If FALSE
    5) Set the subtree balance factor to the result of getting the max balance factor between left child and right child.
     */
    public void updateBalanceFactor(AVLTreeNode<T> subTree){

        if((subTree.leftChild == null) && (subTree.rightChild != null)){
            subTree.balanceFactor = ((subTree.rightChild.balanceFactor) + 1);
        }else if((subTree.rightChild == null) && (subTree.leftChild != null)){
            subTree.balanceFactor = ((subTree.leftChild.balanceFactor) + 1);
        }else{
            subTree.balanceFactor = getMaxNodeBalanceFactor(subTree);
        }
    }

    //Getters & Setters


    public AVLTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(AVLTreeNode<T> root) {
        this.root = root;
    }
}
