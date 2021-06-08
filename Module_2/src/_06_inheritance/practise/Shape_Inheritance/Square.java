package _06_inheritance.practise.Shape_Inheritance;

public class Square extends Rectangle{
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
        return "A square with side="+ getSide()+", which is a subclass of "+ super.toString();
    }
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square("yellow", true, 5.8);
        System.out.println(square);
    }
}
