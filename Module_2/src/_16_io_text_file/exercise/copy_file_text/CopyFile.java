package _16_io_text_file.exercise.copy_file_text;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file =
                    new File("D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\_16_io_text_file\\exercise\\copy_file_text\\Text.txt");
            File result =
                    new File("D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\_16_io_text_file\\exercise\\copy_file_text\\Result.txt");
            if (!file.exists() || !result.exists()) {
                throw new FileNotFoundException();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            bufferedWriter = new BufferedWriter(new FileWriter(result));

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n");
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
