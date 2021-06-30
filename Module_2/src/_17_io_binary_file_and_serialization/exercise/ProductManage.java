package _17_io_binary_file_and_serialization.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
    public static final String FILE_PATH = "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\_17_io_binary_file_and_serialization\\exercise\\List";
    public static Scanner input() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
    static List<Product> newProduct = new ArrayList<>();
    public static Object readFile(String filePath) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        Object read = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            objectInputStream = new ObjectInputStream(fileInputStream);
            read = objectInputStream.readObject();
            return read;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (read!=null){
                System.out.println("Success");
            } else {
                System.out.println("Error!!");
            }
            try {
                fileInputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void writeFile(String filePath,List products){
        File file = new File(filePath);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file,true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addNewProduct() {
        System.out.println("ID:");
        int id = input().nextInt();
        System.out.println("Name");
        String name = input().nextLine();
        System.out.println("Price");
        double price = input().nextDouble();
        Product product = new Product(id,name,price);
        newProduct.add(product);
        new ProductManage().writeFile(FILE_PATH,newProduct);
    }

    public static void displayProduct()  {
        List<Product> products1 = (List<Product>) new ProductManage().readFile(FILE_PATH);
        for (Product product : products1){
            System.out.println(product);
        }
    }

    public static void search(){
        List<Product> products1 = (List<Product>) new ProductManage().readFile(FILE_PATH);
        System.out.println("ID");
        int id = input().nextInt();
        for (Product product : products1){
            if (product.getId()==id){
                System.out.println(product);
                break;
            }
        }
    }


    public static void main(String[] args) {
        while (true){
            System.out.println("1. Display product");
            System.out.println("2. Add new product");
            System.out.println("3. Search");
            System.out.println("4. Exit");
            System.out.println("choice");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                    displayProduct();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("??");
            }
        }
    }

}
