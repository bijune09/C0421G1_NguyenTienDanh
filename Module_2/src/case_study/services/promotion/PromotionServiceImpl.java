package case_study.services.promotion;

import case_study.models.person.Customer;
import case_study.services.booking_and_contract.BookingServiceImpl;
import case_study.services.customer.CustomerServiceImpl;

public class PromotionServiceImpl implements PromotionService {
    @Override
    public void add() {
        
    }

    @Override
    public void remove() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {

    }

    @Override
    public void listOfCustomer() {
        new BookingServiceImpl().display();
    }
}
