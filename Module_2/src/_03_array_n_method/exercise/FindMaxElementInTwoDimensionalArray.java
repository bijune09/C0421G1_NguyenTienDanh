package _03_array_n_method.exercise;

import java.util.Scanner;

public class FindMaxElementInTwoDimensionalArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row, col, i , j;
        System.out.print("Input row :");
        row = scanner.nextInt();
        System.out.print("Input col:");
        col = scanner.nextInt();
        int[][] array = new int[row][col];
        for (i = 0; i<row; i++){
            for (j =0;j<col;j++){
                System.out.print("Input element at ["+i+"]["+j+"] :");
                array[i][j] = scanner.nextInt();
            }
        }
        int max = array[0][0];
        for (i = 0; i < row;i++){
            for (j = 0; j<col;j++){
                if (array[i][j]>max){
                    max = array[i][j];
                }
            }
        }
        System.out.println("The max number in matrix is: "+max);
    }
}
