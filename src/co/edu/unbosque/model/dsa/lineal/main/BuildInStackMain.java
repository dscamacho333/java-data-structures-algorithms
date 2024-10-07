package co.edu.unbosque.model.dsa.lineal.main;

import java.util.Stack;

public class BuildInStackMain {
    public static void main(String[] args){

        Stack<String> stack = new Stack();

        System.out.println("Adding a few elements to the Stack: ");
        stack.push("P1");
        stack.push("P2");
        stack.push("P3");
        stack.push("P4");
        stack.push("P5");

        System.out.println("Printing Stack elements: ");
        for(String aux: stack){
            System.out.println(aux);
        }

        System.out.println("Printing Stack peek/top element: " + stack.peek());

        System.out.println("Popping Stack Element: " + stack.pop());

        System.out.println("Printing Stack elements: ");
        for(String aux: stack){
            System.out.println(aux);
        }


        System.out.println("Printing Stack length: " + stack.size());

        System.out.println("Printing if Stack is empty: " + stack.isEmpty());

    }
}
