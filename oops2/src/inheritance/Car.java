package inheritance;

public class Car extends Vehicle {

    int numDoors;

    public Car(int numDoors){
        super(10);
        System.out.println("Car's Constructor");
        this.numDoors = numDoors;
    }
    public void print(){
        super.print();
        System.out.println("Car - numDoors "+numDoors);
    }
}
