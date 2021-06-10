package _07_abstract_class_n_interface.practise.comparable;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean fill, double radius) {
        super(color, fill, radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius()>o.getRadius()){
            return 1;
        } else if (getRadius() < o.getRadius()){
            return -1;
        } else {
            return 1;
        }
    }
}
