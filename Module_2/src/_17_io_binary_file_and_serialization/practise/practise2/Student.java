package _17_io_binary_file_and_serialization.practise.practise2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private int id;
    private String name;
    private String address;

    public Student() {
    }

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "ntd", "dn"));
        students.add(new Student(2, "tbn", "dn"));
        students.add(new Student(3, "anv", "dn"));
        students.add(new Student(4, "xyz", "dn"));
        students.add(new Student(5, "abc", "dn"));
        writeToFile
                ("D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\_17_io_binary_file_and_serialization\\practise\\practise2\\StudentList", students);
        List<Student> students1 = readDataFromFile("D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\_17_io_binary_file_and_serialization\\practise\\practise2\\StudentList");
        for (Student student : students1) {
            System.out.println(student);
        }
    }
}
