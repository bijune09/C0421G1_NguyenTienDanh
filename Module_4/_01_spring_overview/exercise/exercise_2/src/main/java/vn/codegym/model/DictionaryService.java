package vn.codegym.model;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionary {
    public static Map<String,String> dictionary = new HashMap<>();


    @Override
    public String findWord(String word) {
        dictionary.put("Hello","Mèo méo meo mèo meo");
        dictionary.put("Cat","Chó");
        dictionary.put("Dog","Mèo");
        dictionary.put("June","Tháng six");
        dictionary.put("Nine","Số 9");
        String string = dictionary.get(word);
        if (string!=null){
            return string;
        } else {
            return "not found";
        }
    }
}
