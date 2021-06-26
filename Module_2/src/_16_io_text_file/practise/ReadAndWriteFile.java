package _16_io_text_file.practise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return numbers;
    }

    public void writeFile(String filePath, int max){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị lớn nhất là: " + max+"\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
//        System.out.println("input file");
//        String filePath = scanner.nextLine();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\_16_io_text_file\\practise\\number.txt");
        int maxValue = findMax(numbers);
        System.out.println("Đã đc thêm vào file");
        readAndWriteFile.writeFile("D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\_16_io_text_file\\practise\\result.txt",maxValue);
    }
}
