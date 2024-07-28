package co.edu.unbosque.model.dsa.recursion.main;

import java.util.Scanner;

public class FibonacciSeriesMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to fibonacci series : ");
        System.out.println(fibonacci(sc.nextInt()));

    }

    public static int fibonacci(int n) {
        return ((n == 0)||(n == 1))? 1 : fibonacci(n-1) + fibonacci(n-2);
    }
}
