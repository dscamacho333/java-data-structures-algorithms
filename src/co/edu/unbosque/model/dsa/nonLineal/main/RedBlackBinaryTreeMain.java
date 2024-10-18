package co.edu.unbosque.model.dsa.nonLineal.main;

import co.edu.unbosque.model.dsa.nonLineal.implementations.RedBlackBinaryTreeImplementation;
import co.edu.unbosque.model.dsa.nonLineal.interfaces.IRedBlackBinaryTree;

import java.util.Scanner;

public class RedBlackBinaryTreeMain {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        IRedBlackBinaryTree<Integer> redBlackBinaryTree = new RedBlackBinaryTreeImplementation<>();
        String menu = "*** Red-Black Binary Tree Menu***" + "\n"
                + "1) Insert Node " + "\n"
                + "2) Delete Node " + "\n"
                + "3) Validate if red-black Binary Tree is empty " + "\n"
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
                    redBlackBinaryTree.insert(value);
                    break;
                }
                case 2: {
                    System.out.println("Enter value to be deleted: ");
                    /*
                    int value = sc.nextInt();
                    redBlackBinaryTree.delete(value);
                    */
                    break;
                }
                case 3: {
                    System.out.println("Is it empty?: " + redBlackBinaryTree.isEmpty());
                    break;
                }
                case 4: {
                    redBlackBinaryTree.traverseInOrder();
                    break;
                }
                case 5: {
                    redBlackBinaryTree.traversePreOrder();
                    break;
                }
                case 6: {
                    redBlackBinaryTree.traversePostOrder();
                    break;
                }
                case 7: {
                    System.out.println(redBlackBinaryTree.getMax());
                    break;
                }
                case 8: {
                    System.out.println(redBlackBinaryTree.getMin());
                    break ;
                }
                case 9: {
                    break whileLoop;
                }
            }
        }

    }
}
