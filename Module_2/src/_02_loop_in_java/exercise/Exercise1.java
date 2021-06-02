package _02_loop_in_java.practise;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while (choice != 0){
            System.out.println(" Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the triangle");
            System.out.println("3. Draw the isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Your rectangle has width = 5, height = 3: ");
                    for (int i = 0;i<3;i++){
                        for (int j = 0; j<5; j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Triangle at bottom left: ");
                    for (int i = 1; i <=5; i++){
                        for (int j = 0; j<i; j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    System.out.println("Triangle at top left");
                    for (int i = 7; i>1; i--){
                        for (int j =1; j<i; j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    int height = 8;
                    for (int i = 0; i<height; i++) {
                        for (int j = height - 1; j >= i; j--) {
                            System.out.print(" ");
                        }
                        for (int h = 1; h < i * 2; h++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("You choose nothing");
            }
        }
    }
}
