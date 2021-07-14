package case_study.lib;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Exception {
    static final String REGEX_VILLA = "^SVVL-[0-9]{4}$";
    static final String REGEX_HOUSE = "^SVHO-[0-9]{4}$";
    static final String REGEX_ROOM = "^SVRO-[0-9]{4}$";
    static final String REGEX_SERVICE = "^[A-Z][a-z]{1,}";
    static final String REGEX_POOL_AREA = "^([3-9]\\d|[0-9]\\d{2,})$";
    static final String REGEX_CAPACITY = "^([1]\\d|[1-9])$";
    static final String REGEX_AMOUNT = "^\\d{1,}$";

    public static boolean capacityCheck(String capacity){
        if (Pattern.matches(REGEX_CAPACITY,capacity)){
            return true;
        }
        return false;
    }

    public static int choiceCheck(int choice){
        boolean check = false;
        while (!check){
            try{
                choice = Integer.parseInt(new Scanner(System.in).nextLine());
                check = true;
            } catch (NumberFormatException e){
                System.out.println("You must input number");
            }
        }
        return choice;
    }

    public static void main(String[] args) {
        String[] abc = new String[5];
        System.out.println(Arrays.toString(abc));
    }

}
