package _12_java_collection_framework.practise.practise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Kiên",30,"HT");
        Student student1 = new Student("Hùng",26,"HN");
        Student student2 = new Student("Dũng",25,"HP");
        Student student3 = new Student("Khánh",21,"QN");
        Student student4 = new Student("An",29,"HT");

        List<Student> list = new ArrayList<Student>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        for (Student out : list){
            System.out.println(out);
        }

        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(list,ageComparator);
        System.out.println("Compare age's student");
        for (Student comp : list){
            System.out.println(comp.toString());
        }
    }
}
