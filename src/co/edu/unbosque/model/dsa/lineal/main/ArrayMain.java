package co.edu.unbosque.model.dsa.lineal.main;

import co.edu.unbosque.model.dsa.lineal.implementations.ArrayImplementation;
import co.edu.unbosque.model.dsa.lineal.interfaces.IArray;

import java.util.Scanner;

public class ArrayMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        IArray array = new ArrayImplementation<>(10);

        array.create(0, "Santiago");
        array.create(1, "Miguel");
        array.create(2, "Eliecer");
        array.create(3, "Viviana");

        System.out.println(array.readAll());

        String result = (String) array.read(3);
        System.out.println("The result is: " + result);

        array.update(1, "Gacha");
        System.out.println(array.readAll());

        System.out.println("Index of looked up values is: " + array.read("Santiago"));

        array.delete(3);
        System.out.println(array.readAll());



    }
}
