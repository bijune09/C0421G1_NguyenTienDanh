package _16_io_text_file.exercise.read_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFileCSV{
    public static void main(String[] args) {
        try {
            File file = new File("D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\_16_io_text_file\\exercise\\read_csv\\list_of_country.csv");
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                displayList(addOn(line));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<String> addOn(String line){
        List<String> array = new ArrayList<>();
        if (line!= null){
            String[] splitArray = line.split(",");
            array.addAll(Arrays.asList(splitArray));
        }
        return array;
    }

    public static void displayList(List<String> country){
        System.out.println("ID:"+country.get(0)+", Code:"+country.get(1)+", Name:"+country.get(2));
    }
}
