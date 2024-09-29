package co.edu.unbosque.model.dsa.lineal.main;

import co.edu.unbosque.model.dsa.lineal.implementations.linkedList.DoublyLinkedListImplementation;
import co.edu.unbosque.model.dsa.lineal.interfaces.IDoublyLinkedList;

import java.util.Scanner;

public class DoublyLinkedListMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        IDoublyLinkedList<String> doublyLinkedList = new DoublyLinkedListImplementation<>();
        String menu = "***DoublyLinkedList Menu***" + "\n"
                    + "1) Verify if the DoublyLinkedList is empty" + "\n"
                    + "2) Create Node to tail " + "\n"
                    + "3) Create Node to head" + "\n"
                    + "4) Delete Node from head" + "\n"
                    + "5) Delete Node from tail" + "\n"
                    + "6) Read from head to tail" + "\n"
                    + "7) Read from tail to head" + "\n"
                    + "8) Exit system";


        whileLoop: while(true){

            System.out.println(menu);
            System.out.println("Enter an option: ");
            int option = sc.nextInt();

            switch (option){

                case 1:{
                    System.out.println("Is it empty?: " + doublyLinkedList.isEmpty());
                    break;}
                case 2:{
                    System.out.println("Enter the name to add: ");
                    String name = sc.next();
                    doublyLinkedList.createToTail(name);
                    break;}
                case 3:{
                    System.out.println("Enter the name to add: ");
                    String name = sc.next();
                    doublyLinkedList.createToHead(name);
                    break;}
                case 4:{
                    doublyLinkedList.deleteFromHead();
                    break;}
                case 5:{
                    doublyLinkedList.deleteFromTail();
                    break;}
                case 6:{
                    doublyLinkedList.readFromHeadToTail();
                    break;}
                case 7:{
                    doublyLinkedList.readFromTailToHead();
                    break;}
                case 8:{break whileLoop;}
            }
        }

    }
}
