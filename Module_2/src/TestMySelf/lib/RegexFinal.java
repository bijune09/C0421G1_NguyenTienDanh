package TestMySelf.lib;

public interface RegexFinal {
    String REGEX_NAME = "^[A-Z][a-z]+([ ][A-Z][a-z]+)+$";
    String REGEX_EMAIL = "^[(a-z|A-Z)0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
    String REGEX_PHONE_NUMBER = "^[0]\\d{9}";
    String REGEX_GENDER = "^Male$|^Female$|^LGBT$";
    String REGEX_DAY_OF_BIRTH = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    String REGEX_TYPE_GUEST = "^Diamond|^Gold|^Silver|^Member$";
    String REGEX_ADDRESS = "^\\d{1,}[ a-zA-Z]*";
    String REGEX_IDENTITY_NUMBER = "^\\d{9}";
}
