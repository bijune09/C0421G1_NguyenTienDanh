package final_exam.libs;

import java.util.Scanner;

public interface RegexFinal {
    String REGEX_NAME = "^[A-Z][a-z]+([ ][A-Z][a-z]+)+$";
    String REGEX_EMAIL = "^[(a-z|A-Z)0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
    String REGEX_DAY_OF_BIRTH = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    String REGEX_IDENTITY_NUMBER = "^\\d{9}";
    String REGEX_CODE_PRODUCT = "^SP-\\d{4}";
    String REGEX_IMPORT_PRODUCT = "^Adidas|^Rolex|^Iphone$";
    String REGEX_AMOUNT = "^[+]?([.]\\d+|\\d+[.]?\\d*)$";
    String REGEX_EXPORT_PRODUCT = "^Ao Dai|^Gao$";
    String REGEX_PRICE = "\\d+";
    String REGEX_COUNTRY = "[A-Z][a-z]+";

    public static void main(String[] args) {
        System.out.println("nhập");
        String a = new Scanner(System.in).nextLine();
        new MyCheckRegex().checkLoop(REGEX_COUNTRY, a);
    }
}
