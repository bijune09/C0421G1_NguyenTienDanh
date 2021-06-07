package _05_access_modier_static_method_static_property.practise;

public class Car {
    private String name, engine;
    public static int numberOfCars;
    public Car(String name, String engine){
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public static void setNumberOfCars(int numberOfCars) {
        Car.numberOfCars = numberOfCars;
    }

    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3","Skyactiv 3");
        System.out.println(Car.numberOfCars);
        Car car2 = new Car("Mazda 6","Skyactiv 6");
        System.out.println(Car.numberOfCars);
    }
}
