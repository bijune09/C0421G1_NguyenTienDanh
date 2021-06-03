package _03_array_n_method.practise;

import java.util.Scanner;

public class ConvertTemperature {
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0/5)* celsius +32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0/9)* (fahrenheit - 32);
        return celsius;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double fahrenheit, celsius;
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Fahrenheit : ");
                    fahrenheit = sc.nextDouble();
                    System.out.println("Result: "+fahrenheitToCelsius(fahrenheit)+" Celsius");
                    break;
                case 2:
                    System.out.println("Enter Celsius :");
                    celsius = sc.nextDouble();
                    System.out.println("Result: "+celsiusToFahrenheit(celsius)+ " Fahrenheit");
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }
}
