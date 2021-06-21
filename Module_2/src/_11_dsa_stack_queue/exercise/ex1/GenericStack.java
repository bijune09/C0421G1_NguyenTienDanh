package _11_dsa_stack_queue.exercise.ex1;

import java.util.Scanner;
import java.util.Stack;

public class GenericStack {

    public static void stackOfInteger(){
        //wrong
//        MyGenericStack<Integer> arrayOfInteger = new MyGenericStack<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("How many element you wanna put in?");
//        int number =scanner.nextInt();
//        for (int i =0; i < number; i++){
//            System.out.println("Your number at " + i);
//            int numberInput = scanner.nextInt();
//            arrayOfInteger.push(numberInput);
//        }
//        for (int i = number; i>0;i--){
//            int numberPopOut = arrayOfInteger.pop();
//            arrayOfInteger.push(numberPopOut);
//        }
//        System.out.println("After reversed: "+arrayOfInteger);
        Stack<Integer> arrayOfInteger = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many element you wanna put in?");
        int size =scanner.nextInt();
        for (int i =0; i < size; i++){
            System.out.println("Your number at " + i);
            int numberInput = scanner.nextInt();
            arrayOfInteger.push(numberInput);
        }
        System.out.println("Before reverse: "+arrayOfInteger);
        Stack<Integer> reverseArray = new Stack<>();
        for (int i =0; i <size; i++){
            reverseArray.push(arrayOfInteger.pop());
        }
        System.out.println("After reverse: "+reverseArray);
    }

    public static void stackOfString(){
        // wrong
//        MyGenericStack<String> wStack = new MyGenericStack<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Your word: ");
//        String inputString = scanner.nextLine();
//        String[] mWord = inputString.split(",",inputString.length());
//        for (String string : mWord) {
//            wStack.push(string);
//        }
//        String outPut = "";
//        for (int i = mWord.length-1; i > 0; i--){
//            mWord[i] = wStack.pop();
//        }
//        outPut += mWord;
//        System.out.println(outPut);

        //right
        Stack<String> wStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your word: ");
        String inputString = scanner.nextLine();
        String[] mWord = inputString.split(" ");
        for (String string : mWord) {
            wStack.push(string);
        }
        String outPut = "";
        for (int i = 0; i<mWord.length;i++){
            mWord[i] = wStack.pop();
            outPut += mWord[i]+" ";
        }
        System.out.println("Your words after reversed: "+outPut);
    }

    public static void menu(){
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0){
            System.out.println("Menu choice");
            System.out.println("1. Reversed integer");
            System.out.println("2. Reversed string");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    stackOfInteger();
                    break;
                case 2:
                    stackOfString();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("You choose nothing");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
