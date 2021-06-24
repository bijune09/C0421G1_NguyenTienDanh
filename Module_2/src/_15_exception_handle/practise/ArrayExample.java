package _15_exception_handle.practise;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createRandom(){
        Random random = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("List of elements in array: ");
        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(100);
            System.out.print(arr[i]+" ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.createRandom();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input index:");
        int index = scanner.nextInt();
        try {
            System.out.println("The value of index "+ index+" is: "+arr[index]);
        } catch (IndexOutOfBoundsException e){
            System.err.println("Index out of bounds");
        }
    }
}
