package co.edu.unbosque.model.dsa.lineal.main;

import co.edu.unbosque.model.dsa.lineal.implementations.linkedList.CircularLinkedListImplementation;
import co.edu.unbosque.model.dsa.lineal.interfaces.ICircularLinkedList;

import java.util.Scanner;

public class CircularLinkedListMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ICircularLinkedList<String> circularLinkedList = new CircularLinkedListImplementation();
        String menu = "***CircularLinkedList Menu***" + "\n"
                + "1) Verify if the CircularLinkedList is empty" + "\n"
                + "2) Create Node" + "\n"
                + "3) Delete Node" + "\n"
                + "4) Read Nodes" + "\n"
                + "5) Exit system";

        whileLoop: while (true){

            System.out.println(menu);
            System.out.println("Enter an option: ");
            int option = sc.nextInt();

            switch(option){
                case 1: {
                    System.out.println("Is it empty?: " + circularLinkedList.isEmpty());
                    break;
                }
                case 2: {
                    System.out.println("Enter a name to add: ");
                    String name = sc.next();
                    circularLinkedList.createCircularNode(name);
                    break;
                }
                case 3: {
                    System.out.println("Enter a name to delete: ");
                    String name = sc.next();
                    circularLinkedList.deleteNode(name);
                    break;
                }
                case 4: {
                    circularLinkedList.readAllNodes();
                    break;
                }
                case 5: {
                    break whileLoop;
                }
            }

        }
    }
}
