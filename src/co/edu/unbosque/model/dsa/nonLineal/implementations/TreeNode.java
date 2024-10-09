package co.edu.unbosque.model.dsa.nonLineal.implementations;

public class TreeNode <T>{

    /*
    Every Tree Node has 4 attributes:
    1) Value, representing the element.
    2) Left Child Node, representing the pointer to the left Node.
    3) Right Child Node, representing the pointer to the right Node.
    4) Name, representing the Node name.
     */
    T value;
    TreeNode<T> leftChild;
    TreeNode<T> rightChild;
    String name;

    /*
    Constructor: This one is used to create a new Tree Node from zero.
     */
    public TreeNode(T value, String name){
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.name = name;
    }

    /*
     Method to show the Node info
     1) Override the toString() method from the parent class Object.
     2) Return Node name + Node value.
     */
    @Override
    public String toString(){
        return (name + ": " + value);
    }
}
