package co.edu.unbosque.model.dsa.lineal.main;

import co.edu.unbosque.model.dsa.lineal.implementations.queue.QueueImplementation;
import co.edu.unbosque.model.dsa.lineal.interfaces.IQueue;

import java.util.Scanner;

public class QueueMain {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        IQueue<String> queueImplementation = new QueueImplementation<>();
        String menu = "*** Queue Menu***" + "\n"
                + "1) Enqueue element" + "\n"
                + "2) Dequeue element " + "\n"
                + "3) Validate if queue is empty" + "\n"
                + "4) Get Queue Head value" + "\n"
                + "5) Get Queue Length" + "\n"
                + "6) Read Queue Nodes" + "\n"
                + "7) Exit system";
    }
}
