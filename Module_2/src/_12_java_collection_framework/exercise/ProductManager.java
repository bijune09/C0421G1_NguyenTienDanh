package _12_java_collection_framework.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static Scanner scanner = new Scanner(System.in);
    public static List<Product> products = new ArrayList<>();

    public static void add(){
        System.out.print("Input id of product: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Input name of product:");
        String name = scanner.nextLine();
        System.out.println("Input price of product");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id,name,price);
        products.add(product);
    }

    public static void editProduct(){
        System.out.println("Input id of product");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product sc : products){
            if (sc.getId()==id){
                System.out.println("Input new name's product:");
                String newName = scanner.nextLine();
                System.out.println("Input new price's product:");
                double newPrice = Double.parseDouble(scanner.nextLine());
                sc.setName(newName);
                sc.setPrice(newPrice);
            } else {
                System.out.println("Not found!!");
            }
        }
    }

    public static void displayProduct(){
        System.out.println(products);
    }

    public static void remove(){
        System.out.println("Input id of product");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product sc : products){
            if (sc.getId() == id){
                products.remove(sc);
            } else {
                System.out.println("Not found!!");
            }
        }
    }

    public static void search(){
        System.out.println("Input name of product");
        String name = scanner.nextLine();
        for (Product sc : products){
            if (sc.getName().equals(name)){
                System.out.println(sc);
            } else {
                System.out.println("Not found!!");
            }
        }
    }

    public static void main(String[] args) {

    }
}
