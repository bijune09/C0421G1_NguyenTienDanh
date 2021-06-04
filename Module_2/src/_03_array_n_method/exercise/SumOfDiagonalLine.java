package _03_array_n_method.exercise;

import java.util.Scanner;

public class SumOfDiagonalLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[3][3];
        int i, j, diagonal1 = 0, diagonal2=0;
        for (i =0; i<3;i++){
            for (j=0;j<3;j++){
                System.out.print("Input element at ["+i+"]["+j+"]: ");
                array[i][j] = scanner.nextInt();
            }
        }
        int firstNumber = 0, lastNumber = array.length - 1;
        for (i =0; i<array.length;i++){
            for(j=0;j<array[i].length;j++){
                // đường chéo trái sang phải
                if (i==j){
                    diagonal1 += array[i][j];
                } else if (firstNumber == i && lastNumber ==j){
                    diagonal2 += array[i][j];
                    firstNumber++;
                    lastNumber--;
                }
                // phải sang trái
            }
        }
        System.out.println("Diagonal 1: "+diagonal1);
        System.out.println("Diagonal 2: "+diagonal2);
    }
}
