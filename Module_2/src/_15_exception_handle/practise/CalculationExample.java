package _15_exception_handle.practise;

import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("X: ");
        int x = scanner.nextInt();
        System.out.println("Y: ");
        int y = scanner.nextInt();
        CalculationExample calculationExample = new CalculationExample();
        calculationExample.calculate(x,y);
    }

    private void calculate(int x, int y){
        try {
            int a = x + y;
            int b = x - y;
            int c = x / y;
            int d = x * y;
            System.out.println("Plus: "+a);
            System.out.println("Minus: "+b);
            System.out.println("Divide: "+c);
            System.out.println("Multiple: "+d);
        } catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
