package case_study.services.read_and_write_file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteFile {
    public void writeFile(String filePath, String line){
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
            bufferedWriter.write(line+"\n");
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
}
