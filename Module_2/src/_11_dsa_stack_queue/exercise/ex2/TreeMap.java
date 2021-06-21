package _11_dsa_stack_queue.exercise.ex2;

import java.util.Map;
import java.util.Scanner;

public class TreeMap {
    public static void main(String[] args) {
//        java.util.TreeMap<String, Integer> map = new java.util.TreeMap<>();
        Map<String, Integer> countWord = new java.util.TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write down: ");
        String strings = scanner.nextLine().toUpperCase();
        String[] arrayString = strings.split(" ");
        for (String key : arrayString) {
            if (countWord.containsKey(key)) {
                countWord.put(key, (countWord.get(key) + 1));
            } else {
                countWord.put(key, 1);
            }
        }
        System.out.println(countWord);
//        for (int i = 0; i < arrayString.length; i++) {
//            countWord.put(arrayString[i].toUpperCase(), 0);
//        }
//        for (String key : countWord.keySet()) {
//            for (int i = 0; i < arrayString.length; i++) {
//                if (key.equals(arrayString[i])) {
//                    countWord.replace(key, countWord.get(key) + 1);
//                }
//            }
//        }
//        System.out.println(countWord);
    }
}
