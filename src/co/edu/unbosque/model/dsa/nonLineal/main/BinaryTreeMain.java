package co.edu.unbosque.model.dsa.nonLineal.main;

import co.edu.unbosque.model.dsa.nonLineal.implementations.BinaryTreeImplementation;
import co.edu.unbosque.model.dsa.nonLineal.interfaces.IBinaryTree;

import java.util.Scanner;

public class BinaryTreeMain{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        IBinaryTree<Integer> binaryTreeImplementation = new BinaryTreeImplementation<>();
        String menu = "*** Binary Tree Menu***" + "\n"
                + "1) Create Node with a name " + "\n"
                + "2) Create Node without a name " + "\n"
                + "3) Validate if Binary Tree is empty " + "\n"
                + "4) Read In Order " + "\n"
                + "5) Read Pre Order " + "\n"
                + "6) Read Post Order " + "\n"
                + "7) Exit system";

        whileLoop: while(true){
            System.out.println(menu);
            System.out.println("Enter an option: ");
            int option = sc.nextInt();

            switch(option){
                case 1:{
                    System.out.println("Enter the Node Name: ");
                    String name = sc.next();
                    System.out.println("Enter the Node value: ");
                    int value = sc.nextInt();
                    binaryTreeImplementation.createNode(value,name);
                    break;
                }
                case 2:{
                    System.out.println("Enter the Node value: ");
                    int value = sc.nextInt();
                    binaryTreeImplementation.createNode(value);
                    break;
                }
                case 3:{
                    System.out.println("Is the binary tree empty?: " + binaryTreeImplementation.isEmpty());
                    break;
                }
                case 4:{
                    binaryTreeImplementation.readInOrder(((BinaryTreeImplementation<Integer>) binaryTreeImplementation).getRoot());
                    break;
                }
                case 5:{
                    binaryTreeImplementation.readPreOrder(((BinaryTreeImplementation<Integer>) binaryTreeImplementation).getRoot());
                    break;
                }
                case 6:{
                    binaryTreeImplementation.readPostOrder(((BinaryTreeImplementation<Integer>) binaryTreeImplementation).getRoot());
                    break;
                }
                case 7:{
                    break whileLoop;
                }
            }

        }
    }
}
