package co.edu.unbosque.model.dsa.nonLineal.main;

import co.edu.unbosque.model.dsa.nonLineal.implementations.AVLBinaryTreeImplementation;
import co.edu.unbosque.model.dsa.nonLineal.interfaces.IAVLBinaryTree;

import java.util.Scanner;

public class AVLBinaryTreeMain {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        IAVLBinaryTree<Integer> AVLTree = new AVLBinaryTreeImplementation<>();
        String menu = "*** AVL Binary Tree Menu***" + "\n"
                + "1) Insert Node " + "\n"
                + "2) Delete Node " + "\n"
                + "3) Validate if AVL Binary Tree is empty " + "\n"
                + "4) Read In Order " + "\n"
                + "5) Read Pre Order " + "\n"
                + "6) Read Post Order " + "\n"
                + "7) Get Max Node " + "\n"
                + "8) Get MIn Node " + "\n"
                + "9) Exit system";

        whileLoop:while(true){
            System.out.println(menu);
            System.out.println("Enter an option: ");
            int option = sc.nextInt();

            switch(option){
                case 1: {
                    System.out.println("Enter value to be added: ");
                    int value = sc.nextInt();
                    AVLTree.insert(value);
                    break;
                }
                case 2: {
                    System.out.println("Enter value to be deleted: ");
                    int value = sc.nextInt();
                    AVLTree.delete(value);
                    break;
                }
                case 3: {
                    System.out.println("Is it empty?: " + AVLTree.isEmpty());
                    break;
                }
                case 4: {
                    AVLTree.traverseInOrder();
                    break;
                }
                case 5: {
                    AVLTree.traversePreOrder();
                    break;
                }
                case 6: {
                    AVLTree.traversePostOrder();
                    break;
                }
                case 7: {
                    System.out.println(AVLTree.getMax());
                    break;
                }
                case 8: {
                    System.out.println(AVLTree.getMin());
                    break ;
                }
                case 9: {
                    break whileLoop;
                }
            }
        }

    }

}
