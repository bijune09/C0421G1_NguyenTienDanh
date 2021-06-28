package ForTest.Manger;

public abstract class Service {
    private String service;
    private double area;
    private double price;
    private int capacity;
    private String guestStay;

    public Service() {
    }

    public Service(String service, double area, double price, int capacity, String guestStay) {
        this.service = service;
        this.area = area;
        this.price = price;
        this.capacity = capacity;
        this.guestStay = guestStay;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getGuestStay() {
        return guestStay;
    }

    public void setGuestStay(String guestStay) {
        this.guestStay = guestStay;
    }

}
