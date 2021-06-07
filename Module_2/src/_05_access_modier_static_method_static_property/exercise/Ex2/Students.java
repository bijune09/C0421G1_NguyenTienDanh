package _05_access_modier_static_method_static_property.exercise.Ex2;

public class Students {
    private String name = "John";
    private String classes = "C02";

    Students(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
