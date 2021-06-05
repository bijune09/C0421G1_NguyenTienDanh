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
        System.out.println("Which element you wanna delete in array? ");
        int elementDelete = sc.nextInt();
        boolean check = false;
        int index = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == elementDelete) {
                check = true;
                index = j;
                while (index<array.length-1){
                    array[index] = array[index+1];
                    index++;
                }
                array[array.length-1]=0;
            }
        }
        if (check) {
//            int h = index;
//            while (h < array.length-1) {
//                array[h] = array[h + 1];
//                h++;
//            }
//            array[array.length-1]=0;
            System.out.println("The array has change : ");
            for (int out : array) {
                System.out.print(out + "\t");
            }
        } else {
            System.out.println("Nothing change!!");
        }
    }

}
