package _16_io_text_file.exercise.read_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV extends Country{
    public static void main(String[] args) {
        List<String> countryList = new ArrayList<>();
        try {
            File file =
                    new File("D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\_16_io_text_file\\exercise\\read_csv\\list_of_country.csv");
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                displayList(line);
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    static void displayList(String line){
        List<String> display = new ArrayList<>();
        if (line != null){
            String[] splitArray = line.split(",");
            for (int i =0;i<splitArray.length;i++){
                display.add(splitArray[i]);
            }
        }
        System.out.println(display);
    }

}
