package co.edu.unbosque.model.dsa.recursion.objects;

public class Person {

    //Class atributes
    private String name;
    private String lastName;
    private int age;

    //Constructor with fields
    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    //Empty constructor
    public Person(){}

    //Class methods
    public void getDownstairs(int steps){
        if(steps == 0){
            System.out.println("You are downstairs already!");
        }else{
            System.out.println("Almost there, " + steps + " left!");
            getDownstairs(steps - 1);
        }
    }



    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
