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

        whileLoop: while(true){

            System.out.println(menu);
            System.out.println("Enter an option: ");
            int option = sc.nextInt();

            switch(option){
                case 1:{
                    System.out.println("Enter a name: ");
                    String name = sc.next();
                    queueImplementation.enqueue(name);
                    break;
                }
                case 2:{
                    System.out.println("Element dequeued: " + queueImplementation.dequeue());
                    break;
                }
                case 3:{
                    System.out.println("Is it empty: " + queueImplementation.isEmpty());
                    break;
                }
                case 4:{
                    System.out.println("Queue head is: " + queueImplementation.getQueueHead());
                    break;
                }
                case 5:{
                    System.out.println("Queue length is: " + queueImplementation.getQueueLength());
                    break;
                }
                case 6:{
                    queueImplementation.readQueueNodes();
                    break;
                }
                case 7:{
                    break whileLoop;
                }

            }

        }
    }
}
