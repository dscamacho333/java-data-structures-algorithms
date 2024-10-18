package co.edu.unbosque.model.dsa.nonLineal.implementations;

import co.edu.unbosque.model.dsa.nonLineal.interfaces.IRedBlackBinaryTree;

import static java.awt.Color.BLACK;
import static java.awt.Color.RED;

public class RedBlackBinaryTreeImplementation <T extends Comparable<T>> implements IRedBlackBinaryTree<T> {

    private RedBlackTreeNode<T> root;

    public RedBlackBinaryTreeImplementation(){
        this.root = null;
    }

    /*
    Method to insert a node.
     */
    @Override
    public RedBlackTreeNode<T> insert(T value) {
        RedBlackTreeNode<T> node = new RedBlackTreeNode<>(value);
        root = insert(node,root);
        recolorAndRotate(node);
        return this.root;
    }

    /*
    Method to insert a node and balance the tree.
     */
    private RedBlackTreeNode<T> insert(RedBlackTreeNode<T> nodeToInsert, RedBlackTreeNode<T> node){
        //Case when parent is empty. This case is the goal of using recursion on the other two conditionals, since this one allows to create a new node and point it to the right place.
        if(node == null){
           return nodeToInsert;
        }
        //These conditionals are being used to know whether to go right or left when inserting the new node.
        //A) Value to be inserted less than node value. (Use recursion to move to the left until the first condition is met )
        if(nodeToInsert.value.compareTo(node.value) < 0){

            //Point the node to insert as the parent left child.
            node.leftChild = insert(nodeToInsert, node.leftChild);
            //Point the left child parent to the parent. (To make sure everything goes just fine)
            node.leftChild.parent = node;

        //A) Value to be inserted greater than node value. (Use recursion to move to the right until the first condition is met )
        } else if(nodeToInsert.value.compareTo(node.value) > 0){

            //Point the node to insert as the parent right child.
            node.rightChild = insert(nodeToInsert, node.rightChild );
            //Point the right child parent to the parent. (To make sure everything goes just fine)
            node.rightChild.parent = node;

        }
        return node;
    }

    /*
    Method to handle the recoloring and rotating cases.
     */
    private void recolorAndRotate(RedBlackTreeNode<T> node){
        RedBlackTreeNode<T> parent = node.parent;
        //If the parent of the node which was inserted is RED, there is a violation of the red-black tree rules
        if((node != root) && (parent.color == RED)){

            //Get the grandparent node through pointers to the parent of the parent.
            RedBlackTreeNode<T> grandParent = node.parent.parent;
            //Get the uncle by validating if the parent of the node to be inserted is a left node. If it is true, then the uncle would be the right child of the grandparent.
            RedBlackTreeNode<T> uncle = (parent.isLeftChild())?
                                        (grandParent.rightChild) : (grandParent.leftChild);
            //Validate if we need to recolor or rotate according to the cases.
            //A) Uncle is RED
            if((uncle != null) && (uncle.color == RED)){
                    //Recoloring
                    handleRecoloring(parent,uncle,grandParent);
            //B) Tree is left-heavy
            } else if(parent.isLeftChild()){
                    // right rotation or left-right rotation
                    handleLeftSituations(node,parent, grandParent);
            //C) Tree is right-heavy
            } else if (!(parent.isLeftChild())){
                    // left rotation or right-left rotation
                    handleRightSituations(node,parent,grandParent);
            }
        }

        root.color = BLACK;
    }

    /*
    Method to handle recoloring the red-black tree.
     */
    private void handleRecoloring(RedBlackTreeNode<T> parent,RedBlackTreeNode<T> uncle,RedBlackTreeNode<T> grandParent){
        //Flipping everyone´s color except the new node.
        uncle.flipColor();
        parent.flipColor();
        grandParent.flipColor();
        //Do the same upwards.
        recolorAndRotate(grandParent);
    }

    /*
    Method to handle the left rotations cases.
     */
    private void handleLeftSituations(RedBlackTreeNode<T> node,RedBlackTreeNode<T> parent,RedBlackTreeNode<T> grandParent){

        //If node is right child, we need to rotate to the left and then rotate to the right.
        if(!(node.isLeftChild())){
            rotateLeft(parent);
        }
        //If node is left child, we need to simply rotate to the right.
        parent.flipColor();
        grandParent.flipColor();
        rotateRight(grandParent);
        recolorAndRotate((node.isLeftChild()? parent: grandParent));
    }

    /*
    Method to handle the right rotations cases.
     */
    private void handleRightSituations(RedBlackTreeNode<T> node,RedBlackTreeNode<T> parent,RedBlackTreeNode<T> grandParent){

        if(node.isLeftChild()){
            rotateRight(parent);
        }
        parent.flipColor();
        grandParent.flipColor();
        rotateLeft(grandParent);
        recolorAndRotate((node.isLeftChild()? grandParent:parent));
    }


    /*
    Method to right rotate and left-right rotate.
     */
    private void rotateRight(RedBlackTreeNode<T> node){
        RedBlackTreeNode<T> leftNode = node.leftChild;
        node.leftChild = leftNode.rightChild;
        if(node.leftChild != null){
            node.leftChild.parent = node;
        }
        leftNode.rightChild = node;
        leftNode.parent = node.parent;
        //Updates the pointers of the grandparent.
        updateChildrenOfParentNode(node, leftNode);
        node.parent = leftNode;
    }

    /*
    Method to rotate to the left and right-left rotate.
     */
    private void rotateLeft(RedBlackTreeNode<T> node){
        RedBlackTreeNode<T> rightNode = node.rightChild;
        node.rightChild = rightNode.leftChild;
        if(node.rightChild != null){
            node.rightChild.parent = node;
        }
        rightNode.leftChild = node;
        rightNode.parent = node.parent;
        //Updates the pointers of the grandparent.
        updateChildrenOfParentNode(node, rightNode);
        node.parent = rightNode;
    }

    /*
    Method to update the children of the grandparent node.
     */
    private void updateChildrenOfParentNode(RedBlackTreeNode<T> node,RedBlackTreeNode<T> tempNode){

        //Case 01:  Node is the root.
        if(node.parent == null){
            root = tempNode;
        //Case 02: Node is the left child of the grandparent.
        } else if(node.isLeftChild()){
            node.parent.leftChild = tempNode;
        //Case 03: Node is the right child of the grandparent
        } else{
            node.parent.rightChild = tempNode;
        }
    }

    @Override
    public void delete(T value) {

    }

    /*
    Method to read the Red-Black Tree in order.
     */
    @Override
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    /*
    Method to read the Red-Black Tree in pre-order.
     */
    @Override
    public void traversePreOrder() {
        traversePreOrder(root);
    }

    /*
    Method to read the Red-Black Tree in post-order.
     */
    @Override
    public void traversePostOrder() {
        traversePostOrder(root);
    }

    /*
    Method to implement the In Order access to the tree.
     */
    private void traverseInOrder(RedBlackTreeNode<T> node){
        if(node != null){
            traverseInOrder(node.leftChild);
            System.out.println(node);
            traverseInOrder(node.rightChild);
        }
    }

    /*
    Method to implement the pre Order access to the tree.
     */
    private void traversePreOrder(RedBlackTreeNode<T> node){
        if(node != null){
            System.out.println(node);
            traversePreOrder(node.leftChild);
            traversePreOrder(node.rightChild);
        }
    }

    /*
    Method to implement the post Order access to the tree.
     */
    private void traversePostOrder(RedBlackTreeNode<T> node){
        if(node != null){
            traversePostOrder(node.leftChild);
            traversePostOrder(node.rightChild);
            System.out.println(node);
        }
    }

    /*
    Method to get the max node at the Red-Black Tree.
     */
    @Override
    public T getMax() {
        if(isEmpty()){
            return null;
        }
        return getMax(root);
    }

    /*
    Method to implement the search of the max element within the Red-Black Tree.
     */
    private T getMax(RedBlackTreeNode<T> node){
        if(node.rightChild != null){
            return getMax(node.rightChild);
        }
        return node.value;
    }

    /*
    Method to get the min node at the Red-Black Tree.
     */
    @Override
    public T getMin() {
        if(isEmpty()){
            return null;
        }
        return getMin(root);
    }

    /*
    Method to implement the search of the min element within the Red-Black Tree.
     */
    private T getMin(RedBlackTreeNode<T> node){
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
