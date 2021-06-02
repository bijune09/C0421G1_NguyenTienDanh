package _01_introduct_to_java.practise;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Enter number you wanna spell: ");
        number = scanner.nextInt();
        //
        if (number < 10 && number >= 0) {
            switch (number) {
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
                default:
                    System.out.println("ten");
            }
        } else if (number < 20) {
            switch (number % 10) {
                case 1:
                    System.out.println("eleven");
                    break;
                case 2:
                    System.out.println("twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 4:
                    System.out.println("fourteen");
                    break;
                case 5:
                    System.out.println("fifteen");
                    break;
                case 6:
                    System.out.println("sixteen");
                    break;
                case 7:
                    System.out.println("seventeen");
                    break;
                case 8:
                    System.out.println("eighteen");
                    break;
                case 9:
                    System.out.println("nineteen");
                    break;
                default:
                    System.out.println("ten");
            }
//        } else if (number < 100){
//            String spellOnes, spellTens;
//            switch ((number%100)/10){
//                case 2:
//                    System.out.print("twenty");
//                    break;
//                case 3:
//                    System.out.print("thirty");
//                    break;
//                case 4:
//                    System.out.print("forty");
//                    break;
//                case 5:
//                    System.out.print("fifty");
//                    break;
//                case 6:
//                    System.out.print("sixty");
//                    break;
//                case 7:
//                    System.out.print("seventy");
//                    break;
//                case 8:
//                    System.out.print("eighty");
//                    break;
//                case 9:
//                    System.out.print("ninety");
//                    break;
//            }
//            switch (number%10){
//                case 1:
//                    System.out.print("one");
//                    break;
//                case 2:
//                    System.out.print("two");
//                    break;
//                case 3:
//                    System.out.print("three");
//                    break;
//                case 4:
//                    System.out.print("four");
//                    break;
//                case 5:
//                    System.out.print("five");
//                    break;
//                case 6:
//                    System.out.print("six");
//                    break;
//                case 7:
//                    System.out.print("seven");
//                    break;
//                case 8:
//                    System.out.print("eight");
//                    break;
//                case 9:
//                    System.out.print("nine");
//                    break;
//            }
//        }
        }
    }
}
