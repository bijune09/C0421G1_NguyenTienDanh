package _07_abstract_class_n_interface.exercise.ex1;

public class TestInterface {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();
        System.out.println("Shape before resize");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println("Shape after resize");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println("Circle");
                System.out.println(((Circle) shape).resize(100));
            } else if (shape instanceof Square) {
                System.out.println("Square");
                System.out.println(((Square) shape).resize(100));
            } else if (shape instanceof Rectangle) {
                System.out.println("Rectangle");
                System.out.println(((Rectangle) shape).resize(100));
            }
        }
    }
}

