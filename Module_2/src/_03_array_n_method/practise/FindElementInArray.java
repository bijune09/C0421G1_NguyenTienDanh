package _03_array_n_method.practise;

import java.util.Scanner;

public class FindElementInArray {
    public static void main(String[] args) {
        String[] students =
                {"Christan","Michael","Camila","Sienna","Tanya","Connor","Zachariah","Mallory","Zoe","Emily"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name's student: ");
        String name = sc.nextLine();
        boolean isExit = false;
        for (int i = 0; i<students.length;i++){
            if (name.equals(students[i])){
                System.out.println("Position of the students in the list "+name+" is: "+(i+1));
                isExit =true;
                break;
            }
        }
        if (!isExit){
            System.out.println("Not found "+ name+" in list");
        }
    }
}
