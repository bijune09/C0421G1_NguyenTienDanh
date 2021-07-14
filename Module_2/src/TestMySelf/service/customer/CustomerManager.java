package TestMySelf.service.customer;

import TestMySelf.lib.MyCheckRegex;

public class CustomerManager extends MyCheckRegex {
    public static void menu(){
        while (true){
            System.out.println("-----Menu------");
            System.out.println("1. Display Customer");
            System.out.println("2. Add New Customer");
            System.out.println("3. Edit Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.println("Input your choice");
            int choice = choiceNumberException();
            switch (choice){
                case 1:
                    new CustomerServiceImpl().display();
                    break;
                case 2:
                    new CustomerServiceImpl().add();
                    break;
                case 3:
                    new CustomerServiceImpl().edit();
                    break;
                case 4:
                    new CustomerServiceImpl().delete();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("???????");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
