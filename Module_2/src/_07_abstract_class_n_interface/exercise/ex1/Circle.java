package _07_abstract_class_n_interface.exercise.ex1;

public class Circle extends Shape implements Rezieable{
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()+" and area = " +getArea();
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius()*percent);
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Before resize");
        System.out.println(circle.getArea());
        System.out.println("After resized");
        circle.resize(Math.random()*100);
        System.out.println(circle);
    }
}
