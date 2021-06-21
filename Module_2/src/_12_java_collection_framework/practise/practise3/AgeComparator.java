package _12_java_collection_framework.practise.practise3;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getAge()>student2.getAge()){
            return 1;
        } else if (student1.getAge() == student2.getAge()){
            return 0;
        }
        return -1;
    }
}
