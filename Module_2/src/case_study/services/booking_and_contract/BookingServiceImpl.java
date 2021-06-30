package case_study.services.booking_and_contract;

import case_study.models.booking.Booking;

import java.util.*;

public class BookingServiceImpl implements BookingService{
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }
    public static Set<Booking> bookings = new TreeSet<>();
    static {
        bookings.add(new Booking(1,"12/01/2021","15/01/2021",2,"Karaoke tay vịn","***"));
        bookings.add(new Booking(2,"12/01/2021","12/01/2021",2,"Limousine Car","***"));
        bookings.add(new Booking(3,"16/01/2021","16/01/2021",5,"Bicycle","**"));
        bookings.add(new Booking(4,"17/01/2021","18/01/2021",4,"Board","****"));
    }
    public static Queue<Booking> bookingQueue = new LinkedList<>();
    static {
        bookingQueue.addAll(bookings);
    }

    @Override
    public void add() {
        System.out.println("ID Booking");
        int idBooking = input().nextInt();
        System.out.println("Start Day");
        String first = input().nextLine();
        System.out.println("End Day");
        String last = input().nextLine();
        System.out.println("ID Customer");
        int idCustomer = input().nextInt();
        System.out.println("Service Name");
        String nameOfService = input().nextLine();
        System.out.println("Type Of Service");
        String typeOfService = input().nextLine();
        Booking newBooking = new Booking(idBooking,first,last,idCustomer,nameOfService,typeOfService);
        bookings.add(newBooking);
        System.out.println("Booking Success");
    }

    @Override
    public void remove() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        Iterator iterator = bookings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
