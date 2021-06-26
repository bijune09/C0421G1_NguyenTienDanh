package _15_exception_handle.exercise;

import java.util.Scanner;

public class TriangleTest {
    public static void test(int sideA, int sideB, int sideC) throws IllegalTriangleException {
        if ( (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA)&&(sideA>0||sideB>0||sideC>0)) {
            System.out.println("This is triangle");
        } else {
            throw new IllegalTriangleException("Error!! This is not triangle");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Triangle");
            System.out.println("Side a:");
            int sideA = scanner.nextInt();
            System.out.println("Side b:");
            int sideB = scanner.nextInt();
            System.out.println("Side c:");
            int sideC = scanner.nextInt();
            test(sideA, sideB, sideC);
        } catch (IllegalTriangleException e){
            System.err.println(e.getErrorMess());
        }
    }
}
