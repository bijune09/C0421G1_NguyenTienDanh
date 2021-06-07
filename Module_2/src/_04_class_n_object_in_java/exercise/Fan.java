package _04_class_n_object_in_java.exercise;

public class Fan {
    final int slow =1, medium = 2, fast = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    public double getRadius() {
        return radius;
    }
    public int getSpeed() {
        return this.speed;
    }
    public String getColor() {
        return this.color;
    }
    public boolean getStatus(){
        return this.on;
    }
    public void setRadius(double newRadius) {
        radius = newRadius;
    }
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    public void setColor(String newColor){
        color = newColor;
    }
    public void setStatus(boolean newStatus){
        on = newStatus;
    }
    public Fan(){
        this.speed = slow;
        this.on = false;
        this.radius = 5;
        this.color = "Blue";
    }
    public String toString(){
        if (this.on){
            return "Speed of fan: "+this.speed+"\n"+
                    "Color of fan: "+this.color+"\n"+
                    "Fan's radius : "+this.radius+"\n"+
                    "Fan is on";
        } else {
            return "Speed of fan: "+this.speed+"\n"+
                    "Color of fan: "+this.color+"\n"+
                    "Fan's radius : "+this.radius+"\n"+
                    "Fan is off";
        }
    }
    public static void main(String[] args) {
        Fan fan = new Fan();
        System.out.println(fan.toString());
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.fast);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setStatus(true);
        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.medium);
        fan2.setRadius(5);
        System.out.println("Information of fan 1: ");
        System.out.println(fan1.toString());
        System.out.println("Information of fan 2: ");
        System.out.println(fan2.toString());
    }
}
