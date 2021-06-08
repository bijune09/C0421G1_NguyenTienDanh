package _05_access_modier_static_method_static_property.practise.static_method;

public class TestStudent {
    public static void main(String[] args) {
        Student.change();

        Student student1 = new Student(111,"June");
        Student student2 = new Student(222,"John");
        Student student3 = new Student(333,"Khan");

        student1.display();
        student2.display();
        student3.display();
    }
}
