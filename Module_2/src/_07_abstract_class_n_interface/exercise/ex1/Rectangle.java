package _07_abstract_class_n_interface.exercise.ex1;

public class Rectangle extends Shape  implements Rezieable{
    private double width = 1, length = 1.0;
    public Rectangle(){
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean fill, double width, double length) {
        super(color, fill);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getArea(){
        return this.width*this.length;
    }
    public double getPerimeter(){
        return (this.length+this.width)*2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + getWidth() +
                ", length=" + getLength() + ", area = "+getArea();
    }

    @Override
    public void resize(double percent) {
        setLength(getLength()*percent);
        setWidth(getWidth()*percent);
    }
}
