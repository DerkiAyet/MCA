interface Vehicle {
    void setWheels();
    String getDetails();
}

class Car implements Vehicle {
    private int doors;
    private int wheels;
    private String engine;

    public Car(int doors, String engine) {
        this.doors = doors;
        this.engine = engine;
    }

    @Override
    public void setWheels(){
        this.wheels = 4;
    }

    public int getWheels(){
        return wheels;
    }

    public int getDoors() {
        return doors;
    }

    public String getEngine(){
        return this.engine;
    }

    @Override
    public String getDetails() {
        return "Car with " + doors + " doors and " + getWheels() + " wheels and " + "engine of type :" + getEngine();
    }
}


class Motorcycle implements Vehicle {
    private int cylinders;
    private int wheels;
    private String engine;

    public Motorcycle(int cylinders, String engine) {
        this.cylinders = cylinders;
        this.engine = engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    @Override

    public void setWheels(){
        this.wheels = 2;
    }

    @Override
    public String getDetails() {
        return "Motorcycle with " + cylinders + " cylinders and " + wheels + " wheels and " + "engine of type :" + engine;
    }
}


class Bicycle implements Vehicle {

    private int wheels;
    private String engine;

    public Bicycle(String engine) {
        this.engine = engine;
    }

    @Override
    public void setWheels(){
        this.wheels = 2;
    }

    @Override
    public String getDetails() {
        return "Bicycle with " + wheels + " wheels and " + "engine of type :" + engine;
    }
}

abstract class VehicleFactory {
    protected abstract Vehicle createVehicle();
    public Vehicle create(){     // this what we're gonna work with because if w work with createVehicule the wheels are gonna always be 0
        Vehicle vehicle = createVehicle();
        vehicle.setWheels();
        return vehicle;
    }
}


class CarFactory extends VehicleFactory {
    private int doors;
    private String engine;

    public CarFactory(int doors, String engine) {
        this.doors = doors;
        this.engine = engine;
    }

    @Override
    public Vehicle createVehicle() {
        return new Car(doors, engine);
    }
}


class MotorcycleFactory extends VehicleFactory {
    private int cylinders;
    private String engine;

    public MotorcycleFactory(int cylinders, String engine) {
        this.cylinders = cylinders;
        this.engine = engine;
    }

    @Override
    public Vehicle createVehicle() {
        return new Motorcycle(cylinders, engine);
    }
}

class BicycleFactory extends VehicleFactory {
    private String engine;

    public BicycleFactory(String engine) {
        this.engine = engine;
    }

    @Override
    public Vehicle createVehicle() {
        return new Bicycle(engine);
    }
}


public class FactoryPattern {
    public static void main(String[] args) {

        VehicleFactory carFactory = new CarFactory(4, "car engine");
        Vehicle car = carFactory.create();
        System.out.println(car.getDetails());


        VehicleFactory motorcycleFactory = new MotorcycleFactory(2, "motor engine");
        Vehicle motorcycle = motorcycleFactory.create();
        System.out.println(motorcycle.getDetails());


        VehicleFactory bicycleFactory = new BicycleFactory("bicycle engine");
        Vehicle bicycle = bicycleFactory.create();
        System.out.println(bicycle.getDetails());
    }
}

