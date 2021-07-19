import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.utils.read_and_write_file.ReadAndWriteFile;

import java.util.*;

public class Test  {
    static int abc(String inputString){
        TreeSet<String> list = new TreeSet<>();
        for(int i = 1 ; i <= inputString.length() ; i++){
            for(int j = 0 ; j < inputString.length() - i + 1 ; j++){
                String temp = "";
                for(int k = j ; k < j + i ; k++){
                    temp += inputString.charAt(k);
                }
                list.add(temp);
            }
        }
        return list.size();
    }
    public static void main(String[] args) {
        System.out.println(abc("abac"));
    }
}
