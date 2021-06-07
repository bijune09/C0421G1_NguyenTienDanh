package _05_access_modier_static_method_static_property.exercise.Ex1;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("The radius of this circle is: "+circle.getRadius());
        System.out.println("The area of this circle is: "+circle.getArea());
        Circle circle1 = new Circle(5.0);
        System.out.println("The radius of this circle is: "+circle1.getRadius());
        System.out.println("The area of this circle is: "+circle1.getArea());

    }
}
