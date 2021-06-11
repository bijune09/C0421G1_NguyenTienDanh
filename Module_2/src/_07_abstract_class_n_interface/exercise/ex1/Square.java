package _07_abstract_class_n_interface.exercise.ex1;

public class Square  extends Rectangle implements Rezieable,Colorable{
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

    public double getArea(){
        return this.getSide()*this.getSide();
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
        return "A square with side="+ getSide()+ " , area = " +getArea();
    }
    @Override
    public void resize(double percent) {
        setSide(getSide()*percent);
    }

    @Override
    public void howToColor() {
        System.out.println("Color is all for sides");
    }
}
