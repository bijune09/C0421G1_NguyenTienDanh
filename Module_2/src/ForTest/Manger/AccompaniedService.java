package ForTest.Manger;

public class AccompaniedService {
    private String service;
    private int amount;
    private double price;

    public AccompaniedService() {
    }

    public AccompaniedService(String service, int amount, double price) {
        this.service = service;
        this.amount = amount;
        this.price = price;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AccompaniedService{" +
                "service='" + service + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
