package _05_access_modier_static_method_static_property.exercise.Ex2;

import _05_access_modier_static_method_static_property.practise.Student;

public class TestStudents {
    public static void main(String[] args) {
        Students student = new Students();
        System.out.println(student);
        student.setName("Hùng");
        student.setClasses("C03");
        System.out.println(student);
    }
}
