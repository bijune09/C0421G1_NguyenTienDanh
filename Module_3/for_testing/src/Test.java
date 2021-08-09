import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = "20-08-2000";
        System.out.println(date);

        try {
            System.out.println(simpleDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
