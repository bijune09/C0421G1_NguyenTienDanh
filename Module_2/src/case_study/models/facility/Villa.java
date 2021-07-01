package case_study.models.facility;

public class Villa extends Facility {
    private String standard;
    private double swimmingPoolArea;
    private int floor;

    public Villa() {
    }

    public Villa
            (String name, double area, double price, int capacity, String guestStay, String standard, double swimmingPoolArea, int floor) {
        super(name, area, price, capacity, guestStay);
        this.standard = standard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.floor = floor;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return super.toString()+", standard:"+getStandard()+", Swimming Pool Area:"+getSwimmingPoolArea()+", floor:"+getFloor()+"]";
    }
}
