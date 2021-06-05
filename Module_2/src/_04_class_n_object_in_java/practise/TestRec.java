package _04_class_n_object_in_java.practise;

import java.util.Scanner;

public class TestRec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the width");
        double width = scanner.nextDouble();
        System.out.println("Enter the height");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your rectangle: "+rectangle.display());
        System.out.println("Perimeter of the rectangle: "+rectangle.getPerimter());
        System.out.println("Area of the rectangle: "+rectangle.getArea());
    }
}
