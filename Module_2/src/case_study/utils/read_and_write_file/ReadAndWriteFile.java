package case_study.utils.read_and_write_file;


import case_study.models.facility.Facility;
import case_study.models.facility.House;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadAndWriteFile<K,V> {

    public void writeFile(String filePath, String line,boolean append) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath, append));
            bufferedWriter.write(line + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<K> readFile(String filePath) {
        List<K> list = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                list.add((K) line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public Map<Facility,Integer> readFileWithMap(String filePath){
        Map<Facility,Integer> map = new LinkedHashMap<>();
        BufferedReader bufferedReader = null;
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                //a,b,c,d,e,0
                String[] splitLine = line.split(",");
                String[] key = new String[splitLine.length-1];
                for (int i =0;i < splitLine.length-1;i++){
                    key[i] =  splitLine[i];
                }
                Facility facility = new House
                        (key[0],Double.parseDouble(key[1]),Double.parseDouble(key[2]),
                                Integer.parseInt(key[3]),key[4],key[5],Integer.parseInt(key[6]));
                int value = Integer.parseInt(splitLine[splitLine.length-1]);
                map.put(facility,value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void deleteContentFromCSV(String filePath){
        FileWriter fileWriter = null;
        PrintWriter writer = null;
        try {
            fileWriter = new FileWriter(filePath);
            writer = new PrintWriter(fileWriter);
            writer.write("");
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}