package case_study.utils.read_and_write_file_line;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ReadAndWriteFileLine<E> {
    public void writeFile(String filePath, String line) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
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

    public List<E> readFile(String filePath) {
        List<E> list = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                list.add((E) line);
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

    public void displayList(List<E> list) {

    }
}
