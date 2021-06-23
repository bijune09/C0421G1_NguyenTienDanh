package _14_sort_algorithm.practise;

import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter list size");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter "+ list.length+" values: ");
        for (int i =0; i< size; i++){
            list[i] = scanner.nextInt();
        }
        System.out.println("Your input list: ");
        for (int i : list){
            System.out.println(i);
        }

        System.out.println("-------Sort-------");
        bubbleSortByStep(list);
    }

    public static void bubbleSortByStep(int[] list){
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++){
            needNextPass = false;
            for (int i =0; i<list.length-k;i++){
                if (list[i]>list[i+1]){
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;

                    needNextPass = true;
                }
            }
            if (needNextPass == false){
                System.out.println("Array maybe be sorted and next pass not needed");
                break;
            }
            System.out.println("List after the "+k+" sort: ");
            for (int i : list){
                System.out.println(i);
            }
        }
        System.out.println();
    }
}
