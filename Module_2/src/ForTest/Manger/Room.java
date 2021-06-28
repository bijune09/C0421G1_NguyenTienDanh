package ForTest.Manger;

public class Room extends Service {
    private String complimentary;

    public Room() {
    }

    public Room(String freeService) {
        this.complimentary = freeService;
    }

    public Room(String service, double area, double price, int capacity, String guestStay, String complimentary) {
        super(service, area, price, capacity, guestStay);
        this.complimentary = complimentary;
    }

    public String getComplimentary() {
        return complimentary;
    }

    public void setComplimentary(String complimentary) {
        this.complimentary = complimentary;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Complimentary='" + complimentary + '\'' +
                '}';
    }
}
