package _14_sort_algorithm.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many element you wanna input in?");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Input element:");
        for (int i=0;i<size;i++){
            array[i] = scanner.nextInt();
        }
        System.out.println("Array original: ");
        System.out.println(Arrays.toString(array));
        System.out.println("----Sort-----");
        sort1(array);
    }

    static void displayArray(int[] array){
        for (int i : array){
            System.out.println(i);
        }
    }

    static void sort1(int[] array){
        int index = 0;
        int temp = 0;
        for(int i = 1; i < array.length; i++){
            temp = array[i];
            index = i;
            while(index > 0 && temp < array[index-1]){
                array[index] = array[index-1];
                index--;
            }
            array[index] = temp;
        }
        displayArray(array);
    }

}
