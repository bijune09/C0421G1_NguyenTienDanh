package _15_exception_handle.practise;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear equation resolver");
        System.out.println("Given a equation ' ax + b = 0' please enter constant:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: ");
        double a = scanner.nextDouble();
        System.out.println("b:");
        double b = scanner.nextDouble();
        if (a!=0){
            double solution = -b/a;
            System.out.println("The solution is: "+solution);
        } else {
            if (b==0){
                System.out.println("The solution is all x");
            } else {
                System.out.println("No solution");
            }
        }

    }
}
