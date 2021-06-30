package case_study.services.booking_and_contract;

import case_study.models.booking.Contract;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ContractServiceImpl implements ContractService {
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    public static Queue<Contract> contracts = new LinkedList<>();
    static {
    }

    @Override
    public void add() {
        System.out.println("ID Contract");
        int idContract = input().nextInt();
        System.out.println("ID Booking");
        int idBooking = input().nextInt();
        System.out.println("Deposit");
        double deposit = input().nextDouble();
        System.out.println("Amount has been paid");
        double amountPaid = input().nextDouble();
        System.out.println("ID Customer");
        int idCustomer = input().nextInt();
        Contract newContract = new Contract(idContract,idBooking,deposit,amountPaid,idCustomer);
        contracts.add(newContract);
    }

    @Override
    public void remove() {

    }

    @Override
    public void edit() {
        System.out.println("Please input ID Contract");
        int findID = input().nextInt();
        for (Contract contract : contracts){
            if (contract.getIdContract()==findID){
                System.out.println("ID Booking");
                int newIdBooking = input().nextInt();
                System.out.println("Deposit");
                double newDeposit = input().nextDouble();
                System.out.println("Amount has been paid");
                double newAmountPaid = input().nextDouble();
                System.out.println("ID Customer");
                int newIdCustomer = input().nextInt();
                contract.setIdBooking(newIdBooking);
                contract.setDeposit(newDeposit);
                contract.setAmountPaid(newAmountPaid);
                contract.setIdCustomer(newIdCustomer);
                System.out.println("Success!!");
                break;
            }
        }
    }

    @Override
    public void display() {
        for (Contract contract : contracts){
            System.out.println(contract);
        }
    }
}
