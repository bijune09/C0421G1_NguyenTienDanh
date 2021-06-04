package _03_array_n_method.exercise;

import com.sun.prism.impl.shape.BasicRoundRectRep;

import java.util.Scanner;

public class SumOfCol {
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
        System.out.print("Enter column you wanna sum in matrix: ");
        int inputCol = scanner.nextInt(), sum = 0, h =0;
        while (h<array.length){
            sum += array[h][inputCol];
            h++;
        }
        System.out.println("Sum of column is: "+sum);
    }
}
