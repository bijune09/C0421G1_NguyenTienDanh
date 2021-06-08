package DemoAnhTrung;

import java.util.Scanner;

public class DemoList {
    private static Scanner scanner = new Scanner(System.in);
    public static Students[] students;
    static {
        students = new Students[50];
        students[0]= new Students(1,"Trung",33,"Đà Nẵng");
        students[1]= new Students(2,"Nhật",23,"Quảng Nam");
        students[2]= new Students(3,"Tài",24,"Quảng Ngãi");
        students[3]= new Students(4,"Minh",25,"Vinh");
    }
    public static void main(String[] args) {
        System.out.println("--Chương trình quản lý sinh viên--");
        while (true){
            System.out.println("Menu chương trình");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Chỉnh sửa thông tin sinh viên");
            System.out.println("4. Thêm mới sinh viên");
            System.out.println("5. Thoát chương trình ");
            System.out.println("Chọn chức năng muốn sử dụng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    displayStudent(students);
                    break;
                case 2:
                    deleteStudent(students);
                    break;
                case 3:
                    System.out.println("Thông tin sinh viên");
                    break;
                case 4:
                    addStudent(students);
                    break;
                case 5:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Bạn đã nhập sai. Vui lòng nhập lại");
            }
        }
    }
    private static String inputFromKeyboard(String messsage){
        System.out.print(messsage);
        String output = scanner.nextLine();
        return output;
    }
    private static void displayStudent (Students[] students){
        for (Students student : students){
            if (student != null){
                System.out.println(student);
            }
        }
    }
    private static void deleteStudent (Students[] students){
        int deleteStudent = Integer.parseInt(inputFromKeyboard("Nhập tên sinh viên muốn xóa: "));
//        for (int i = 0; i<students.length; i++){
//            if (deleteStudent.equals(students[i])){
//                students[i]=null;
//            }
//        }
    }
    private static void addStudent (Students[] students){
        int id = Integer.parseInt(inputFromKeyboard("Nhập id cho sinh viên mới: "));
        String name = inputFromKeyboard("Nhập tên cho sinh viên mới: ");
        int age = Integer.parseInt(inputFromKeyboard("Nhập tuổi cho sinh viên mới: "));
        String address = inputFromKeyboard("Nhập địa chỉ cho sinh viên mới: ");
        Students newStudent = new Students(id, name, age , address);
        for (int i = 0; i< students.length; i++){
            if (students[i]==null){
                students[i] = newStudent;
                break;
            }
        }
    }
}
