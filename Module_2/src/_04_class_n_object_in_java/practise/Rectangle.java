package _04_class_n_object_in_java.practise;

public class Rectangle {
    double width, height;
    public Rectangle(){
    }
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        return this.width*this.height;
    }
    public double getPerimter(){
        return (this.height+this.width)*2;
    }
    public String display(){
        return "Rectangle { width = "+width+", height = "+height+"}";
    }

}
