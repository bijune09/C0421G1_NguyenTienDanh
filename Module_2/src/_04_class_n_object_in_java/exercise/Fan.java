package _04_class_n_object_in_java.exercise;

public class Fan {
    private final int SLOW= 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "Blue";
    // Getter
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
    // Setter
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
    // Constructor
    public Fan(){
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    // method

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
//        Fan fan1 = new Fan();
//        fan1.setSpeed(fan1.FAST);
//        fan1.setRadius(10);
//        fan1.setColor("Yellow");
//        fan1.setStatus(true);
//        Fan fan2 = new Fan();
//        fan2.setSpeed(fan2.MEDIUM);
//        fan2.setRadius(5);
//        System.out.println("Information of fan 1: ");
//        System.out.println(fan1.toString());
//        System.out.println("Information of fan 2: ");
//        System.out.println(fan2.toString());
    }
}
