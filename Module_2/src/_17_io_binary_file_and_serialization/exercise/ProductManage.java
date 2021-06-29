//package _17_io_binary_file_and_serialization.exercise;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class ProductManage {
//    public static final String FILE_PATH = "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\_17_io_binary_file_and_serialization\\exercise\\List";
//    public static Scanner input() {
//        Scanner scanner = new Scanner(System.in);
//        return scanner;
//    }
//    static List<Product> newProduct = new ArrayList<>();
//    public List<Product> readFile(String filePath) {
//        List<Product> list = new ArrayList<>();
//        try {
//            FileInputStream fileInputStream = new FileInputStream(filePath);
//            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
//            list = (List<Product>) ois.readObject();
//            ois.close();
//            fileInputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public void writeFile(String filePath,List<Product> products){
//        try {
//            FileOutputStream fos = new FileOutputStream(filePath,true);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(products);
//            fos.close();
//            oos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void addNewProduct() {
//        System.out.println("ID:");
//        int id = input().nextInt();
//        System.out.println("Name");
//        String name = input().nextLine();
//        System.out.println("Price");
//        double price = input().nextDouble();
//        Product product = new Product(id,name,price);
//        newProduct.add(product);
//        System.out.println(newProduct);
//        new ProductManage().writeFile(FILE_PATH,newProduct);
//    }
//
//    public static void displayProduct(){
//        List<Product> products1 = new ProductManage().readFile(FILE_PATH);
//        for (Product product : products1){
//            System.out.println(product);
//        }
//    }
//
//    public static void search()
//
//    public static void main(String[] args) {
//
//    }
//
//}
