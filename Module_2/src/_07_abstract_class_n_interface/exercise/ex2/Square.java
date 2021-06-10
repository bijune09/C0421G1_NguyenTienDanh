package _07_abstract_class_n_interface.exercise.ex2;

public class Square extends Rectangle implements Colorable{
    public Square(){
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean fill, double side) {
        super(color, fill, side, side);
    }

    public double getSide(){
        return this.getWidth();
    }
    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "A square with side="+ getSide()+" and area is"+getArea();
    }
    public double getArea(){
        return getSide()*getSide();
    }

    @Override
    public void howToColor() {
        System.out.println("Color is all four sides");
    }
}
