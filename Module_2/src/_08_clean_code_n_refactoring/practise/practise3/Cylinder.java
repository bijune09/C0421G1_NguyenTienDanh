package _08_clean_code_n_refactoring.practise.practise3;

public class Cylinder {
    public static double getVolume(int radius, int height){
        double baseArea = getPerimeter(radius);
        double perimeter = getBaseArea(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    public static double getPerimeter(int radius){
        return 2 * Math.PI  * radius;
    }
    public static double getBaseArea(int radius){
        return Math.PI * radius * radius;
    }
}
