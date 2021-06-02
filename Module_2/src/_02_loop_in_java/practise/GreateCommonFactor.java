package _02_loop_in_java.practise;

import java.util.Scanner;

public class GreateCommonFactor {
    public static void main(String[] args) {
        int a , b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a:");
        a = sc.nextInt();
        System.out.println("Input b:");
        b = sc.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a==0||b==0){
            System.out.println("There is no greatest common factor");
        } else {
            while (a != b){
                if (a > b){
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            System.out.println("The greatest common factor is : "+ a);
        }
    }
}
