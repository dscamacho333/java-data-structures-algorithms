package co.edu.unbosque.model.dsa.nonLineal.main;

import co.edu.unbosque.model.dsa.nonLineal.implementations.AVLBinaryTreeImplementation;
import co.edu.unbosque.model.dsa.nonLineal.implementations.AVLTreeNode;
import co.edu.unbosque.model.dsa.nonLineal.interfaces.IAVLBinaryTree;

import java.util.Scanner;

public class AVLBinaryTreeMain {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        IAVLBinaryTree<Integer> AVLTree = new AVLBinaryTreeImplementation<>();
        String menu = "*** AVL Binary Tree Menu***" + "\n"
                + "1) Create Node " + "\n"
                + "2) Read Node " + "\n"
                + "3) Validate if AVL Binary Tree is empty " + "\n"
                + "4) Read In Order " + "\n"
                + "5) Read Pre Order " + "\n"
                + "6) Read Post Order " + "\n"
                + "7) Exit system";

        whileLoop:while(true){
            System.out.println(menu);
            System.out.println("Enter an option: ");
            int option = sc.nextInt();

            switch(option){
                case 1: {
                    System.out.println("Enter value to be added: ");
                    int value = sc.nextInt();
                    AVLTree.createNode(value);
                    break;
                }
                case 2: {
                    System.out.println("Enter value to be looked for: ");
                    int value = sc.nextInt();
                    System.out.println(AVLTree.readNode(value,((AVLBinaryTreeImplementation<Integer>) AVLTree).getRoot()));
                    break;
                }
                case 3: {
                    System.out.println("Is it empty?: " + AVLTree.isEmpty());
                    break;
                }
                case 4: {
                    AVLTree.readInOrder(((AVLBinaryTreeImplementation<Integer>) AVLTree).getRoot());
                    break;
                }
                case 5: {
                    AVLTree.readPreOrder(((AVLBinaryTreeImplementation<Integer>) AVLTree).getRoot());
                    break;
                }
                case 6: {
                    AVLTree.readPostOrder(((AVLBinaryTreeImplementation<Integer>) AVLTree).getRoot());
                    break;
                }
                case 7: {
                    break whileLoop;
                }
            }
        }

    }
}
