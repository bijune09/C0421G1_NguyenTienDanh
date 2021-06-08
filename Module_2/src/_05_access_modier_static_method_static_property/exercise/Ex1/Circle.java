package _05_access_modier_static_method_static_property.exercise.Ex1;

public class Circle {
    private static final double PI = 3.14159;
    private double radius = 1.0;
    private String color = "red";

    Circle(){
    }
    Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return this.radius*this.radius*PI;
    }

}
