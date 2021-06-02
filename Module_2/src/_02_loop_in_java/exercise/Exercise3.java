package _02_loop_in_java.exercise;

public class Exercise3 {
    public static void main(String[] args) {
        int number = 1;
        while(number<100){
            int count = 0;
            for (int i =1; i<=number;i++){
                if (number%i==0){
                    count++;
                }
            }
            if (count == 2){
                System.out.println(number);
            }
            number++;
        }
    }
}
