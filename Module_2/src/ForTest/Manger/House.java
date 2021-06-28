package ForTest.Manger;

public class House extends Service {
    private String typeOfVilla;
    private String description;
    private int floor;

    public House() {
    }

    public House(String typeOfVilla, String description, int floor) {
        this.typeOfVilla = typeOfVilla;
        this.description = description;
        this.floor = floor;
    }

    public House
            (String service, double area, double price, int capacity, String guestStay, String typeOfVilla, String description, int floor) {
        super(service, area, price, capacity, guestStay);
        this.typeOfVilla = typeOfVilla;
        this.description = description;
        this.floor = floor;
    }

    public String getTypeOfVilla() {
        return typeOfVilla;
    }

    public void setTypeOfVilla(String typeOfVilla) {
        this.typeOfVilla = typeOfVilla;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +
                "typeOfVilla='" + typeOfVilla + '\'' +
                ", description='" + description + '\'' +
                ", floor=" + floor +
                '}';
    }
}
