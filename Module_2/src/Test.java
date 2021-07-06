import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.utils.read_and_write_file.ReadAndWriteFile;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test  {
    static final String REGEX_VILLA = "^SVVL-[0-9]{4}$";
    static final String REGEX_HOUSE = "^SVHO-[0-9]{4}$";
    static final String REGEX_ROOM = "^SVRO-[0-9]{4}$";
    static final String REGEX_SERVICE = "^[A-Z][a-z]{1,}";
    static final String REGEX_NUMBER = "^([3-9]\\d|[0-9]\\d{2,})$";




    public static void main(String[] args) {
        String input = "";
        Pattern pattern = Pattern.compile(REGEX_NUMBER);
        Matcher matcher = pattern.matcher(input);
        System.out.println(matcher.matches());
    }
//    Mã dịch vụ phải đúng định dạng: SVXX-YYYY, với YYYY là các số từ 0-9, XX là:
//    - Nếu là Villa thì XX sẽ là VL
    //- Nếu là House thì XX sẽ là HO
    //- Nếu Room thì XX sẽ là RO
}
