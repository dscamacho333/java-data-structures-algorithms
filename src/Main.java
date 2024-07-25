import co.edu.unbosque.model.dsa.lineal.implementations.ArrayImplementation;

public class Main {
    public static void main(String[] args) {

        ArrayImplementation<Integer> array = new ArrayImplementation<>(10);


        System.out.println(array.readAll());

        array.create(0, 15);
        array.create(1, 80);
        array.create(2, 7);

        System.out.println("Type: " + array.getType());

        System.out.println(array.readAll());

    }
}
