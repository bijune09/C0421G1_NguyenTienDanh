package case_study.models.booking;

public class Booking implements Comparable<Booking>{
    private int idBooking;
    private String first;
    private String last;
    private int idCustomer;
    private String serviceName;
    private String typeOfService;

    public Booking(int idBooking, String first, String last, int idCustomer, String serviceName, String typeOfService) {
        this.idBooking = idBooking;
        this.first = first;
        this.last = last;
        this.idCustomer = idCustomer;
        this.serviceName = serviceName;
        this.typeOfService = typeOfService;
    }

    public Booking() {
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", idCustomer=" + idCustomer +
                ", serviceName='" + serviceName + '\'' +
                ", typeOfService='" + typeOfService + '\'' +
                '}';
    }


    @Override
    public int compareTo(Booking o) {
        if (this.getFirst().equals(o.getFirst())){
            return this.getLast().compareTo(o.getLast());
        }
        return this.getFirst().compareTo(o.getFirst());
    }
}
