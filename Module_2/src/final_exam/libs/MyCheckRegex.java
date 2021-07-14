package final_exam.libs;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MyCheckRegex implements RegexFinal {

    public static Scanner input() {
        return new Scanner(System.in);
    }

    public boolean checkRegex(String regex, String name) {
        if (Pattern.matches(regex, name)) {
            return true;
        }
        return false;
    }

    public String checkLoop(String regex, String line) {
        while (!checkRegex(regex, line)) {
            System.out.println("Wrong Type:");
            line = new Scanner(System.in).nextLine();
        }
        return line;
    }

    public int choiceNumberException() {
        int choice;
        while (true) {
            String line = input().nextLine();
            if (line.trim().equals("")) {
                System.out.println("You can't leave it with blank");
                continue;
            }
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("You must enter number");
                continue;
            }
            return choice;
        }
    }

}

