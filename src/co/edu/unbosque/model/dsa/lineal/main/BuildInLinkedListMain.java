package co.edu.unbosque.model.dsa.lineal.main;

import java.util.LinkedList;

public class BuildInLinkedListMain {
    public static void main(String[] args){

        LinkedList<Integer> list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        for(Integer aux: list){
            System.out.println(aux);
        }

        list.remove(2);

        System.out.println("-------------------------------");

        for(Integer aux: list){
            System.out.println(aux);
        }
    }
}
