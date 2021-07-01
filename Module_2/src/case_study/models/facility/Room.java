package case_study.models.facility;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String name, double area, double price, int capacity, String guestStay, String freeService) {
        super(name, area, price, capacity, guestStay);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString()+", free service:"+getFreeService()+"]";
    }

}
