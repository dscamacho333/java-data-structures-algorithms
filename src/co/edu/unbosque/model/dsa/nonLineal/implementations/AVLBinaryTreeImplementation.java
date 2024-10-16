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
    Method to insert a value into the AVL Tree.
     */
    @Override
    public AVLTreeNode<T> insert(T value) {
        root = insert(value, root);
        return this.root;
    }

    /*
    Method to insert a value into the AVL Tree and identify where it has to be located.
     */
    private AVLTreeNode<T> insert(T value, AVLTreeNode<T> node){
        if(node == null){
            return new AVLTreeNode<>(value);
        }
        if(value.compareTo(node.value) < 0){
            node.leftChild = insert(value, node.leftChild);
        } else if(value.compareTo(node.value) > 0){
            node.rightChild = insert(value, node.rightChild);
        } else{
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    /*
    Method to delete a Node form the AVL Tree.
     */
    @Override
    public void delete(T value) {
        root = delete(value, root);
    }

    /*
    Method to delete a Node form the AVL Tree and organize it to keep it balanced.
     */
    private AVLTreeNode<T> delete(T value, AVLTreeNode<T> node){
        if(node == null){
            return null;
        }
        if(value.compareTo(node.value) < 0){
            node.leftChild = delete(value, node.leftChild);
        } else if(value.compareTo(node.value) > 0){
            node.rightChild = delete(value, node.rightChild);
        } else {
            // One Child or leaf node (no children)
            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            }
            //Two Children
            node.value = getMax(node.leftChild);
            node.leftChild = delete(node.value, node.leftChild);
        }
        updateHeight(node);
        return applyRotation(node);
    }

    /*
    Method to update the height of the nodes when being balanced.
     */
    private void updateHeight(AVLTreeNode<T> node){
        node.height = Math
                .max(
                        height(node.leftChild),
                        height(node.rightChild)
                    ) + 1;
    }

    /*
    Method to get the height of the AVL Node.
     */
    private int height(AVLTreeNode<T> node){
        return (node != null)? (node.height) : 0;
    }

    /*
    Method to apply the suitable rotation depending on the case.
     */
    private AVLTreeNode<T> applyRotation( AVLTreeNode<T> node){
        int balance = balance(node);
        //There are two main cases:
        //A) Tree is left heavy
        if( balance > 1){
            //Case 3: And subtree is right heavy (left rotate the subtree to then right rotate it).
            if(balance(node.leftChild) < 0){
                node.leftChild = rotateLeft(node.leftChild);
            }
            //Case 1: Simple right rotation to balance the tree.
            return rotateRight(node);
        }
        //B) Tree is right heavy
        if( balance < -1){
            //Case 4: And subtree is left heavy (right rotate the subtree to then rotate to the left)
            if(balance(node.rightChild) > 0){
                node.rightChild = rotateRight(node.rightChild);
            }
            //Case 2: Simple left rotation to balance the tree.
            return rotateLeft(node);
        }
        return node;
    }

    /*
    Method to rotate the tree to the right.
     */
    private AVLTreeNode<T> rotateRight(AVLTreeNode<T> node){
        AVLTreeNode<T> leftNode = node.leftChild;
        AVLTreeNode<T> centerNode = leftNode.rightChild;
        leftNode.rightChild = node;
        node.leftChild  = centerNode;
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    /*
    Method to rotate the tree to the left.
     */
    private AVLTreeNode<T> rotateLeft(AVLTreeNode<T> node){
        AVLTreeNode<T> rightNode = node.rightChild;
        AVLTreeNode<T> centerNode = rightNode.leftChild;
        rightNode.leftChild = node;
        node.rightChild = centerNode;
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    /*
    Method to get the balance factor of the specified node.
     */
    private int balance(AVLTreeNode<T> node){
        return (node != null)
                ? (height(node.leftChild) - height(node.rightChild))
                : (0);
    }

    /*
    Method to read the AVL Tree in order.
     */
    @Override
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    /*
    Method to read the AVL Tree in pre-order.
     */
    @Override
    public void traversePreOrder() {
        traversePreOrder(root);
    }

    /*
    Method to read the AVL Tree in post-order.
     */
    @Override
    public void traversePostOrder() {
        traversePostOrder(root);
    }

    /*
    Method to implement the In Order access to the tree.
     */
    private void traverseInOrder(AVLTreeNode<T> node){
        if(node != null){
            traverseInOrder(node.leftChild);
            System.out.println(node);
            traverseInOrder(node.rightChild);
        }
    }

    /*
    Method to implement the pre Order access to the tree.
     */
    private void traversePreOrder(AVLTreeNode<T> node){
        if(node != null){
            System.out.println(node);
            traversePreOrder(node.leftChild);
            traversePreOrder(node.rightChild);
        }
    }

    /*
    Method to implement the post Order access to the tree.
     */
    private void traversePostOrder(AVLTreeNode<T> node){
        if(node != null){
            traversePostOrder(node.leftChild);
            traversePostOrder(node.rightChild);
            System.out.println(node);
        }
    }

    /*
    Method to get the max node at the AVL Tree.
     */
    @Override
    public T getMax() {
        if(isEmpty()){
            return null;
        }
        return getMax(root);
    }

    /*
    Method to implement the search of the max element within the AVL Tree.
     */
    private T getMax(AVLTreeNode<T> node){
        if(node.rightChild != null){
            return getMax(node.rightChild);
        }
        return node.value;
    }

    /*
    Method to get the min node at the AVL Tree.
     */
    @Override
    public T getMin() {
        if(isEmpty()){
            return null;
        }
       return getMin(root);
    }

    /*
    Method to implement the search of the min element within the AVL Tree.
     */
    private T getMin(AVLTreeNode<T> node){
        if(node.leftChild != null){
            return getMin(node.leftChild);
        }
        return node.value;
    }

    /*
    Method to validate if the AVL Tree is empty.
     */
    @Override
    public boolean isEmpty() {
        return (root == null);
    }
}
