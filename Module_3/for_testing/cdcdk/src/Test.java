import java.time.LocalDate;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n");
        int n = sc.nextInt();
        System.out.println("y");
        int y = sc.nextInt();
        int dayOfYear = LocalDate.ofYearDay(y,n).getDayOfMonth();
        int monthOfYear = LocalDate.ofYearDay(y,n).getMonthValue();
        System.out.println(dayOfYear);
        System.out.println(monthOfYear);
    }
}
