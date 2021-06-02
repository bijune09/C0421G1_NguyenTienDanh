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
        } else if (number < 100) {
            String spellOnes ="", spellTens ="";
            switch ((number % 100) / 10) {
                case 2:
                    spellTens = "twenty";
                    break;
                case 3:
                    spellTens = "thirty";
                    break;
                case 4:
                    spellTens = "forty";
                    break;
                case 5:
                    spellTens = "fifty";
                    break;
                case 6:
                    spellTens = "sixty";
                    break;
                case 7:
                    spellTens = "seventy";
                    break;
                case 8:
                    spellTens = "eighty";
                    break;
                case 9:
                    spellTens = "ninety";
                    break;
            }
            switch (number % 10) {
                case 1:
                    spellOnes = "one";
                    break;
                case 2:
                    spellOnes = "two";
                    break;
                case 3:
                    spellOnes = "three";
                    break;
                case 4:
                    spellOnes = "four";
                    break;
                case 5:
                    spellOnes = "five";
                    break;
                case 6:
                    spellOnes = "six";
                    break;
                case 7:
                    spellOnes = "seven";
                    break;
                case 8:
                    spellOnes = "eight";
                    break;
                case 9:
                    spellOnes = "nine";
                    break;
            }
            System.out.println(spellTens +" "+ spellOnes);
        } else if (number<999){
            String spellOnes = "", spellTens = "", spellHundred ="";
            switch (number/100){
                case 1:
                    spellHundred = "One hundred and ";
                    break;
                case 2:
                    spellHundred = "Two hundred and ";
                    break;
                case 3:
                    spellHundred = "Three hundred and ";
                    break;
                case 4:
                    spellHundred = "Four hundred and ";
                    break;
                case 5:
                    spellHundred = "Five hundred and ";
                    break;
                case 6:
                    spellHundred = "Six hundred and ";
                    break;
                case 7:
                    spellHundred = "Seven hundred and ";
                    break;
                case 8:
                    spellHundred = "Eight hundred and ";
                    break;
                case 9:
                    spellHundred = "Nine hundred and ";
                    break;
            }
            switch (number%100/10){
                case 2:
                    spellTens = "twenty";
                    break;
                case 3:
                    spellTens = "thirty";
                    break;
                case 4:
                    spellTens = "forty";
                    break;
                case 5:
                    spellTens = "fifty";
                    break;
                case 6:
                    spellTens = "sixty";
                    break;
                case 7:
                    spellTens = "seventy";
                    break;
                case 8:
                    spellTens = "eighty";
                    break;
                case 9:
                    spellTens = "ninety";
                    break;
            }
            switch (number%10) {
                case 1:
                    spellOnes = "one";
                    break;
                case 2:
                    spellOnes = "two";
                    break;
                case 3:
                    spellOnes = "three";
                    break;
                case 4:
                    spellOnes = "four";
                    break;
                case 5:
                    spellOnes = "five";
                    break;
                case 6:
                    spellOnes = "six";
                    break;
                case 7:
                    spellOnes = "seven";
                    break;
                case 8:
                    spellOnes = "eight";
                    break;
                case 9:
                    spellOnes = "nine";
                    break;
            }
            System.out.println(spellHundred+spellTens+" "+spellOnes);
        } else {
            System.out.println("Out of range!!");
        }
    }
}
