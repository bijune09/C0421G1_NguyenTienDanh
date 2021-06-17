package _11_dsa_stack_queue.exercise.ex1;

import java.util.Scanner;

public class GenericStack {

    public static void stackOfInteger(){
        MyGenericStack<Integer> arrayOfInteger = new MyGenericStack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many element you wanna put in?");
        int number =scanner.nextInt();
        for (int i =0; i < number; i++){
            System.out.println("Your number at " + i);
            int numberInput = scanner.nextInt();
            arrayOfInteger.push(numberInput);
        }
        System.out.println(arrayOfInteger);
        for (int i = number; i>0;i--){
            int numberPopOut = arrayOfInteger.pop();
            arrayOfInteger.push(numberPopOut);
        }
        System.out.println("After reversed: "+arrayOfInteger);
    }

    public static void stackOfString(){
        MyGenericStack<String> wStack = new MyGenericStack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your word: ");
        String inputString = scanner.nextLine();
        String[] mWord = inputString.split(",",inputString.length());
        for (String string : mWord) {
            wStack.push(string);
        }
        String outPut = "";
        for (int i =0; i < wStack.size(); i++){
            mWord[i] = wStack.pop();
            outPut += mWord[i]+" ";
        }
        System.out.println(outPut);
    }

    public static void main(String[] args) {
        stackOfInteger();
        stackOfString();
    }
}
