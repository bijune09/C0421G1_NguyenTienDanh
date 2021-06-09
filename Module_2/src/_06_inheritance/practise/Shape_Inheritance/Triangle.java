package _06_inheritance.practise.Shape_Inheritance;

public class Triangle extends Shape{
    private double side1=1, side2=1, side3=1;
    public Triangle(){}

    public Triangle(String color, boolean fill, double side1, double side2, double side3) {
        super(color, fill);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter(){
        return this.side1+this.side2+this.side3;
    }
    public double getHalfPerimeter(){
        return this.getPerimeter()/2;
    }
    public double getArea(){
        double s = this.getHalfPerimeter()*
                (this.getHalfPerimeter()-getSide1())*
                (this.getHalfPerimeter()-getSide2())*
                        (this.getHalfPerimeter()-getSide3());
        return Math.pow(s,0.5);
    }
}
