package case_study.models.facility;

import java.io.Serializable;

public abstract class Facility implements Serializable {
    private String name;
    private double area;
    private double price;
    private int capacity;
    private String guestStay;

    public Facility() {
    }

    public Facility(String name, double area, double price, int capacity, String guestStay) {
        this.name = name;
        this.area = area;
        this.price = price;
        this.capacity = capacity;
        this.guestStay = guestStay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "[name:'" + name + '\'' + ", area:" + area + ", price:" + price + ", capacity:" + capacity +
                ", guestStay:'" + guestStay + '\'';
    }

}
