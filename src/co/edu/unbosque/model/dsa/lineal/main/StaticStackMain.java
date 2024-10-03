package co.edu.unbosque.model.dsa.lineal.main;

import co.edu.unbosque.model.dsa.lineal.implementations.stack.StaticStackImplementation;
import co.edu.unbosque.model.dsa.lineal.interfaces.IStack;

import java.util.Scanner;

public class StaticStackMain {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        IStack<String> staticStackImplementation = new StaticStackImplementation(5);
        String menu = "*** StaticStack Menu***" + "\n"
                + "1) Push element into Stack" + "\n"
                + "2) Pop element from the Stack " + "\n"
                + "3) Validate if Stack is empty" + "\n"
                + "4) Validate if Stack is full" + "\n"
                + "5) Get the element at the top of the Stack" + "\n"
                + "6) Get Stack length" + "\n"
                + "7) Clear Stack" + "\n"
                + "8) Read Stack" + "\n"
                + "9) Exit system";


        whileLoop: while(true){

            System.out.println(menu);
            System.out.println("Enter an option: ");
            int option = sc.nextInt();

            switch(option){
                case 1: {
                    System.out.println("Enter a name: ");
                    String name = sc.next();
                    staticStackImplementation.push(name);
                    break;
                }
                case 2: {
                    System.out.println("Element popped: " + staticStackImplementation.pop());
                    break;
                }
                case 3: {
                    System.out.println("Is it empty?: " + staticStackImplementation.isEmpty() );
                    break;
                }
                case 4: {
                    System.out.println("Is it full?: " + staticStackImplementation.isFull() );
                    break;
                }
                case 5: {
                    System.out.println("Element at the top: " + staticStackImplementation.getTop());
                    break;
                }
                case 6: {
                    System.out.println("Stack length: " + staticStackImplementation.getStackLength());
                    break;
                }
                case 7: {
                    staticStackImplementation.clearStack();
                    break;
                }
                case 8: {
                    staticStackImplementation.readStack();
                    break;
                }
                case 9: {
                    break whileLoop;
                }

            }
        }
    }
}
