package _06_inheritance.exercise.ex2;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setX(x);
        super.setY(y);
        setZ(z);
    }

    public float[] getXYZ() {
        float[] getXYZ = new float[]{getX(), getY(), this.z};
        return getXYZ;
    }

    @Override
    public String toString() {
        return "Point3D{" + "x = " + getX() + ", y= " + getY() +
                ", z=" + getZ() + ", array[x,y,z] = " + Arrays.toString(getXYZ()) + "}\n which is subclass of " + super.toString();
    }

    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        point3D.setXYZ(3, 4, 5);
        System.out.println(point3D);
    }
}
