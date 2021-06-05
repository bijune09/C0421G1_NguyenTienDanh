package _04_class_n_object_in_java.exercise;

import javafx.scene.transform.Scale;

import java.util.Scanner;

public class QuadraticEquation {
    double a, b, c, delta;
    public QuadraticEquation(){
    }
    private QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA(){
        return this.a;
    }
    public double getB(){
        return this.b;
    }
    public double getC(){
        return this.c;
    }
    public double getDelta(){
        return delta = (Math.pow(this.b,2))-(4*this.a*this.c);
    }
    public double getRoot1(){
        return (-this.b+Math.pow(this.getDelta(),0.5))/(2*this.a);
    }
    public double getRoot2(){
        return (-this.b-Math.pow(this.getDelta(),0.5))/(2*this.a);
    }
    public String getDiscriminant(){
        if (this.getDelta()>0){
            return "The equation has 2 roots \n"+
                    "The first root is: "+this.getRoot1()+"\n"+
                    "The second root is:"+this.getRoot2();
        } else if (this.getDelta()==0){
            return "The equation has one root :"+ this.getRoot1();
        } else {
            return "The equation has no roots";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a:");
        double a = scanner.nextDouble();
        System.out.print("Enter b:");
        double b = scanner.nextDouble();
        System.out.print("Enter c:");
        double c = scanner.nextDouble();
        QuadraticEquation test = new QuadraticEquation(a,b,c);
        System.out.println(test.getDiscriminant());
    }
}
