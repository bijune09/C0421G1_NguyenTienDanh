package _07_abstract_class_n_interface.practise.comparator;

public class Circle extends Shape{
    private double radius = 1;

    public Circle(){}
    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean fill, double radius) {
        super(color, fill);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return this.radius*this.radius*Math.PI;
    }
    public double getPerimeter(){
        return 2*this.radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Cirle has radius = "+ getRadius()+", which is subclass of" +super.toString();
    }

}
