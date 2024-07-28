package co.edu.unbosque.model.dsa.recursion.main;

import java.util.Scanner;

public class FactorialNumberMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        System.out.println("Factorial is: " + factorial(sc.nextInt()));


    }

    public static int factorial(int n) {
        return (n ==0 )? 1 : n * factorial(n - 1);
    }

}
