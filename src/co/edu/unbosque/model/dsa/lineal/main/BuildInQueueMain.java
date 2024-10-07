package co.edu.unbosque.model.dsa.lineal.main;

import java.util.LinkedList;
import java.util.Queue;

public class BuildInQueueMain {
    public static void main(String[] args){

        Queue<String> queue = new LinkedList<>();

        System.out.println("Adding a few elements to the Queue ");
        queue.add("P1");
        queue.add("P2");
        queue.add("P3");
        queue.add("P4");
        queue.add("P5");

        System.out.println("Printing Queue elements ");
        for(String aux: queue){
            System.out.println(aux);
        }


        System.out.println("Emptying the Queue manually");

        while(!(queue.isEmpty())){
            System.out.println("Removing element from queue: " + queue.remove());
        }

        System.out.println("Getting queue size: " + queue.size());


        System.out.println("Adding a few elements to the Queue.");
        queue.add("P1");
        queue.add("P2");
        queue.add("P3");
        queue.add("P4");
        queue.add("P5");

        System.out.println("Printing Queue elements ");
        for(String aux: queue){
            System.out.println(aux);
        }

        System.out.println("Emptying the Queue using build-in method");
        queue.clear();

        System.out.println("Is it empty: " + queue.isEmpty());

    }
}
