package _02_loop_in_java.practise;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        double money = 1;
        int month = 1;
        double interestRate = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your investment amount");
        money = scanner.nextDouble();

        System.out.println("How long?");
        month = scanner.nextInt();

        System.out.println("Interest Rate?");
        interestRate = scanner.nextDouble();

        double totalInterest = 0;
        for (int i = 0; i<month;i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.println("Total of interest = " + totalInterest);
    }
}
