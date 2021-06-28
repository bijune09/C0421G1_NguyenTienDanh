package ForTest.Manger;

public class Villa extends House {
    private double swimmingPoolArea;

    public Villa() {
    }

    public Villa
            (String service, double area, double price, int capacity, String guestStay, String typeOfVilla, String description, int floor, double swimmingPoolArea) {
        super(service, area, price, capacity, guestStay, typeOfVilla, description, floor);
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "swimmingPoolArea=" + swimmingPoolArea +
                '}';
    }


}
