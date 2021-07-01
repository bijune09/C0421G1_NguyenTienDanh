package case_study.models.facility;

public class House extends Facility{
    private String standard;
    private int floor;

    public House() {
    }

    public House(String name, double area, double price, int capacity, String guestStay, String standard, int floor) {
        super(name, area, price, capacity, guestStay);
        this.standard = standard;
        this.floor = floor;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return super.toString()+", standard:"+getStandard()+", floor:"+getFloor()+"]";
    }


}
