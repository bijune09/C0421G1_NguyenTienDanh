package _03_array_n_method.practise;

import java.util.Scanner;

public class CountPassStudents {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter size");
            size = scanner.nextInt();
            if (size>30){
                System.out.println("Size shouldn't exceed 30");
            }
        }while (size>30);
        array = new int[size];
        int i=0, count = 0;
        while (i<array.length){
            System.out.print("Enter mark for student:" + i+ " :");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("List of mark: ");
        for (int j = 0; j<array.length;j++){
            System.out.print(array[j]+"\t");
            if (array[j]>=5 && array[j]<= 10){
                count++;
            }
        }
        System.out.print("\n The number of students passing the exam is: "+count);
    }
}
