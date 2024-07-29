package co.edu.unbosque.model.dsa.lineal.main;

import co.edu.unbosque.model.dsa.lineal.implementations.linkedList.LinkedListImplementation;
import java.util.Scanner;

public class LinkedListMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedListImplementation<String> list = new LinkedListImplementation<>();

        whileLoop: while(true){

            System.out.println("Enter an option: ");
            int option = sc.nextInt();

            switch(option){
                case 1:{
                    sc.nextLine();
                    System.out.println("Enter a name: ");
                    list.createToHead(sc.nextLine());
                    break;
                }
                case 2:{
                    sc.nextLine();
                    System.out.println("Enter a name: ");
                    list.createToTail(sc.nextLine());
                    break;
                }
                case 3:{}
                case 4:{
                    list.deleteFromHead();
                    break;
                }
                case 5:{
                    list.deleteFromTail();
                    break;
                }
                case 6:{
                    sc.nextLine();
                    System.out.println("Enter a name you want to delete: ");
                    list.deleteSpecificNode(sc.nextLine());
                    break;
                }
                case 7:{
                    sc.nextLine();
                    System.out.println("Enter a name you want to look for: ");
                    System.out.println("Is the name on the LinkedList?: " + list.contains(sc.nextLine()));
                    break;
                }
                case 8:{
                    list.readAll();
                    System.out.println("");
                    break;
                }
                case 9:{
                    System.out.println("Is the LinkedList empty?: " + list.isEmpty());
                    break;
                }
                case 10:{
                    break whileLoop;
                }
            }

        }



    }
}
