package _16_io_text_file.practise;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public static void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("Total :" + sum);
        } catch (Exception e) {
            System.err.println("File not found or error !");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input file");
        String path = scanner.nextLine();
        readFileText(path);
    }
}
