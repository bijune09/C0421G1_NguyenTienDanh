package _03_array_n_method.exercise;

import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter your size for array:");
        size = sc.nextInt();
        int[] array = new int[size];
        int i = 0;
        while (i < size) {
            System.out.print("Enter element at " + i+" :");
            array[i] = sc.nextInt();
            i++;
        }
        System.out.println("Which is element you wanna delete in array? ");
        int elementDelete = sc.nextInt();
        boolean count = false;
        int index = 0;
        for (int j = 0; j < array.length; j++) {
            if (elementDelete == array[j]) {
                count = true;
                index = j;
            }
        }
        if (count) {
            int h = index;
            while (h < array.length) {
                // Error!
                array[h] = array[h + 1];
                h++;
            }
            array[array.length - 1] = 0;
            for (int out : array) {
                System.out.print("The elements has change :" + out + "\t");
            }
        } else {
            System.out.println("Nothing change!!");
        }
    }
}
