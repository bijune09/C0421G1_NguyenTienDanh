package _12_java_collection_framework.exercise;

import java.util.*;

public class ProductManagerLinkedList {
    private static Scanner scanner = new Scanner(System.in);
    public static List<Product> productsLinkedList = new LinkedList<>();
    private static boolean check = false;

    public static void add() {
        System.out.print("Input id of product: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Input name of product:");
        String name = scanner.nextLine();
        System.out.println("Input price of product");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, price);
        productsLinkedList.add(product);
    }

    public static void edit() {
        System.out.println("Input id of product");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product sc : productsLinkedList) {
            if (sc.getId() == id) {
                System.out.println("Input new name's product:");
                String newName = scanner.nextLine();
                System.out.println("Input new price's product:");
                double newPrice = Double.parseDouble(scanner.nextLine());
                sc.setName(newName);
                sc.setPrice(newPrice);
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Not found!!");
        }
    }

    public static void displayProduct() {
        for (Product product : productsLinkedList) {
            System.out.println(product);
        }
    }

    public static void remove() {
        System.out.println("Input id of product");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product sc : productsLinkedList) {
            if (sc.getId() == id) {
                productsLinkedList.remove(sc);
                check = true;
                System.out.println("The product has been deleted!");
                break;
            }
        }
        if (check == false) {
            System.out.println("Not found!!");
        }
    }

    public static void search() {
        System.out.println("Input name of product");
        String name = scanner.nextLine();
        for (Product sc : productsLinkedList) {
            if (sc.getName().equals(name)) {
                System.out.println(sc);
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Not found!!");
        }
    }

    public static void ascending() {
        Collections.sort(productsLinkedList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        System.out.println("The price list after sort: ");
        displayProduct();
    }

    public static void descending() {
        Collections.sort(productsLinkedList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getPrice() - o1.getPrice());
            }
        });
        System.out.println("The price list after sort: ");
        displayProduct();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu of product");
            System.out.println("1. Add new product");
            System.out.println("2. Edit product");
            System.out.println("3. Remove product");
            System.out.println("4. Display product");
            System.out.println("5. Search ");
            System.out.println("6. Price list ascending");
            System.out.println("7. Price list descending");
            System.out.println("0. Exit");
            System.out.println("What you wanna do?");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    add();
                    break;
                case 2:
                    edit();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    displayProduct();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    ascending();
                    break;
                case 7:
                    descending();
                    break;
                default:
                    System.out.println("??");
            }
        }
    }

}
