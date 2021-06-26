package _15_exception_handle.exercise;

import java.util.Scanner;

public class Triangle {
    private int sideA, sideB, sideC;

    public Triangle() {
    }

    public Triangle(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }

    public void test(int sideA, int sideB, int sideC) throws IllegalTriangleException {
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA ) {
            throw new IllegalTriangleException("Error!! This is not triangle");
        } else if (sideA < 0 || sideB < 0 || sideC < 0) {
            throw new IllegalTriangleException("Error!! This is not triangle");
        } else {
            System.out.println("This is triangle");
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
            Triangle triangle = new Triangle(sideA,sideB,sideC);
            triangle.test(sideA,sideB,sideC);
        } catch (IllegalTriangleException e){
            System.err.println(e.getErrorMess());
        }
    }
}
