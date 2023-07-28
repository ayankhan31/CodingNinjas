package Interface;

public class Car extends Vehicle implements VehicleInterface,CarInterface{


    public boolean isMotorized(){
        return true;
    }

    public String getCompany(){
        return null;
    }

    @Override
    public int numGears() {
        return 5;
    }
}
