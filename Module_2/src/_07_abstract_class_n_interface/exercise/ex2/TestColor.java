package _07_abstract_class_n_interface.exercise.ex2;

public class TestColor {
    public static void main(String[] args) {
        Shape[] newShape = new Shape[3];
        newShape[0] = new Circle();
        newShape[1] = new Rectangle(2,3);
        newShape[2] = new Square(4);

        for (Shape shape : newShape){
            if (shape instanceof Square){
                System.out.println("Square has area:");
                System.out.println(((Square) shape).getArea());
                ((Colorable) shape).howToColor();
            } else if (shape instanceof Circle){
                System.out.println("Circle has area:");
                System.out.println(((Circle) shape).getArea());
            } else if (shape instanceof Rectangle){
                System.out.println("Rectangle has area:");
                System.out.println(((Rectangle) shape).getArea());
            }
        }
    }
}
