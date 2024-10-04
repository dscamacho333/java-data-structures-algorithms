package co.edu.unbosque.model.dsa.lineal.main;

import co.edu.unbosque.model.dsa.lineal.implementations.stack.DynamicStackImplementation;
import co.edu.unbosque.model.dsa.lineal.interfaces.IDynamicStack;

import java.util.Scanner;

public class DynamicStackMain {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        IDynamicStack<String> dynamicStackImplementation = new DynamicStackImplementation<>();
        String menu = "*** Dynamic Stack Menu***" + "\n"
                + "1) Push element into Stack" + "\n"
                + "2) Pop element from the Stack " + "\n"
                + "3) Validate if Stack is empty" + "\n"
                + "4) Get the element at the top of the Stack" + "\n"
                + "5) Get Stack length" + "\n"
                + "6) Clear Stack" + "\n"
                + "7) Exit system";

        whileLoop: while(true){
            System.out.println(menu);
            System.out.println("Enter an option: ");
            int option = sc.nextInt();

            switch(option){
                case 1:{
                    System.out.println("Enter a name: ");
                    String name = sc.next();
                    dynamicStackImplementation.push(name);
                    break;
                }
                case 2:{
                    System.out.println("Element popped: " + dynamicStackImplementation.pop());
                    break;
                }
                case 3:{
                    System.out.println("is it empty?: " + dynamicStackImplementation.isEmpty());
                    break;
                }
                case 4:{
                    System.out.println("Element at the top is: " + dynamicStackImplementation.getTop());
                    break;
                }
                case 5:{
                    System.out.println("Stack length is: " + dynamicStackImplementation.getStackLength());
                    break;
                }
                case 6:{
                    dynamicStackImplementation.clearStack();
                    break;
                }
                case 7:{
                    break whileLoop;
                }
            }
        }
    }
}
