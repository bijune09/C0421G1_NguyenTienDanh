
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

public class Test  {
    static String checkDay(int day,int month,int year){
        LocalDate localDate = LocalDate.of(year,month,day);
        return String.valueOf(localDate);
    }

    public static void main(String[] args) throws IOException {
        LocalDate localDate = LocalDate.of(2015,8,5);
        System.out.println(localDate.getDayOfWeek());
        String a = "alo?";
        String b = "ola?";
        String builder = a.concat(" "+b);
        System.out.println(builder);
        System.out.println(a.compareTo(b));
    }
}
