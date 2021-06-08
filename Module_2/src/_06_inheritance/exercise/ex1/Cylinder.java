package _06_inheritance.exercise.ex1;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(){}

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return super.getArea()*this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                " height= " + getHeight() +
                " and volume = " + getVolume()+", which is subclass of "+super.toString();
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(3,"blue",4);
        System.out.println(cylinder);
    }
}
