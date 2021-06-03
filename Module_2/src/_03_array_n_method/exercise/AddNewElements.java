package _03_array_n_method.exercise;

import java.util.Scanner;

public class AddNewElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {10,4,6,8,7,0,0,0,0,0};
        int newNumber=0, index=0,i=0;
        System.out.println("Input the number you wanna put in:");
        newNumber = sc.nextInt();
        System.out.println("Position you want: ");
        index = sc.nextInt();
        if (index<array.length){
            for (i = array.length-2;i>=index;i--){
                array[i+1]=array[i];
            }
            array[index]=newNumber;
            for (int elementOuts : array){
                System.out.print(elementOuts+" ");
            }
        } else {
            System.out.println("Can't add more elements");
        }
    }
}
