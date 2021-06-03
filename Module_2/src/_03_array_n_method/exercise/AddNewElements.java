package _03_array_n_method.exercise;

import java.util.Scanner;

public class AddNewElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {10,4,6,7,8,0,0,0,0,0};
        int newNumber, index;
        System.out.println("Input the number you wanna put in:");
        newNumber = sc.nextInt();
        System.out.println("Position you want: ");
        index = sc.nextInt();
        if (index<=1||index>=array.length-1){
            System.out.println("Can't add element");
        } else {
            for (int i = index;i<array.length;i++){
                array[i+1] = array[i];
            }
            array[index] = newNumber;
        }
        for (int out : array){
            System.out.println(out);
        }
    }
}
