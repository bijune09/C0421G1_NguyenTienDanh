package _02_loop_in_java.exercise;

public class Exercise2 {
    public static void main(String[] args) {
        int countPrime = 0;
        int number = 1;
        while(true){
            int count = 0;
            for (int i =1; i<=number;i++){
                if (number%i==0){
                    count++;
                }
            }
            if (count == 2){
                System.out.println(number);
                countPrime++;
            }
            if (countPrime==20){
                break;
            }
            number++;
        }
    }
}
