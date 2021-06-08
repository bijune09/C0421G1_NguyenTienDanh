package _06_inheritance.exercise.ex2;

import java.util.Arrays;

public class Point2D {
    private float x=0.0f,y=0.0f;
    public Point2D(){

    }
    public Point2D(float[] xy){}
    public Point2D(float x, float y){
        this.x = x;
        this.y =y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x= x;
        this.y= y;
    }
    public float[] getXY(){
        float[] getXY = new float[2];
        getXY[0]= this.x;
        getXY[1]=this.y;
        return getXY;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                " x= " + getX() +
                ", y= " + getY() +
                ", arr[x,y] = "+ Arrays.toString(getXY())+" }";
    }

    public static void main(String[] args) {
        Point2D point2D = new Point2D(4,5);
        point2D.setXY(3,4);
        System.out.println(point2D);
    }
}
