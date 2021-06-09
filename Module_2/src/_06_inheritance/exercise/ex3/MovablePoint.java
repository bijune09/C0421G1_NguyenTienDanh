package _06_inheritance.exercise.ex3;

import java.util.Arrays;

public class MovablePoint  extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        float[] getSpeed = new float[2];
        getSpeed[0] = this.xSpeed;
        getSpeed[1] = this.ySpeed;
        return getSpeed;
    }


    @Override
    public String  toString() {
        return "MovablePoint{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}'+"\n speed = ("+ Arrays.toString(getSpeed()) +")";
    }

    public void move(){
        this.setX(getX()+getxSpeed());
        this.setY(getY()+getySpeed());
    }

    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(3,4,5,6);
        System.out.println(movablePoint);
        movablePoint.move();
        System.out.println(movablePoint);
    }
}
