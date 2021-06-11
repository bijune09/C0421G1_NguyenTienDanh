package _07_abstract_class_n_interface.exercise.ex1;

public class TestInterfaceAndColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();
        shapes[3] = new Square(2);
        shapes[4] = new Circle(5.5);
        System.out.println("Shape before resize");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println("Shape after resize");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println("Circle");
                ((Circle) shape).resize(Math.random()*100);
                System.out.println(shape);
            } else if (shape instanceof Square) {
                System.out.println("Square");
                ((Square) shape).resize(Math.random()*100);
                System.out.println(shape);
                ((Square) shape).howToColor();
            } else if (shape instanceof Rectangle) {
                System.out.println("Rectangle");
                ((Rectangle) shape).resize(Math.random()*100);
                System.out.println(shape);
            }
        }
    }
}

