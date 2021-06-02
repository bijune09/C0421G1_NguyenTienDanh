package _01_introduct_to_java.exercise;

import java.util.Scanner;

public class Excerise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double vnd = 23000, usd;
        System.out.print("Input the money: ");
        usd = sc.nextDouble();
        double rate = usd * vnd;
        System.out.print("Convert to VND : " + rate);
    }
}
