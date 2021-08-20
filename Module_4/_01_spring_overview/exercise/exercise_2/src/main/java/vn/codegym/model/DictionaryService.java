package vn.codegym.model;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionary {
    private static Map<String,String> dictionary = new HashMap<>();
    static {
        dictionary.put("Hello","Mèo méo meo mèo meo");
        dictionary.put("Cat","Chó");
        dictionary.put("Dog","Mèo");
        dictionary.put("June","Tháng six");
        dictionary.put("Nine","Số 9");
    }


    @Override
    public String findWord(String word) {
        String string = dictionary.get(word);
        return string;
    }
}
