package _03_array_n_method.exercise;

import java.util.Scanner;

public class FindMinElement {
    public static int min(int[] array) {
        int min = array[0];
        int index = 0;
        for (int i = 1; i<array.length;i++){
            if (array[i]<min){
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter your size");
        size = sc.nextInt();
        int[] array = new int[size];
        int i = 0;
        while (i<array.length){
            System.out.println("Enter element at "+i);
            array[i] = sc.nextInt();
            i++;
        }
        int index = min(array);
        System.out.println("The smallest element in the array is : "+ array[index]);
    }
}
