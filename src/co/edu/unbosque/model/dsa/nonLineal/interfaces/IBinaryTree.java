package co.edu.unbosque.model.dsa.nonLineal.interfaces;

import co.edu.unbosque.model.dsa.nonLineal.implementations.TreeNode;

public interface IBinaryTree <T> {

    void createNode(T value, String name);
    void createNode(T value);
    boolean isEmpty();
    void readInOrder(TreeNode<T> root);
    void readPreOrder(TreeNode<T> root);
    void readPostOrder(TreeNode<T> root);
    TreeNode<T> readNode(T value);
    boolean deleteNode(T value);
    boolean validateIfNodeExists(TreeNode<T> aux,TreeNode<T> parent, boolean isLeftChild, T value);
    void validateNodeChildren(TreeNode<T> aux,TreeNode<T> parent, boolean isLeftChild);
    void deleteFirstCase(TreeNode<T> aux,TreeNode<T> parent, boolean isLeftChild);
    void deleteSecondCase(TreeNode<T> aux,TreeNode<T> parent, boolean isLeftChild);
    void deleteThirdCase(TreeNode<T> aux,TreeNode<T> parent, boolean isLeftChild);
    void deleteFourthCase(TreeNode<T> aux,TreeNode<T> parent, boolean isLeftChild);
    TreeNode<T> getReplacementNode(TreeNode<T> replacedNode);




}
