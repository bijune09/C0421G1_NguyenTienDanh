package _14_sort_algorithm.exercise;

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

    }

    static void displayArray(int[] array){
        for (int i : array){
            System.out.println(i);
        }
    }

    static void sort(int[] array){
        
    }

}
