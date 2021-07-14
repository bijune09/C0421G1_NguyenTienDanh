package final_exam.controller;

import TestMySelf.service.customer.CustomerServiceImpl;
import final_exam.libs.MyCheckRegex;
import final_exam.service.ProductServiceImpl;

public class ProductManagement extends MyCheckRegex {
    public void displayProductManagement(){
        while (true){
            while (true){
                System.out.println("-----Menu------");
                System.out.println("1. Display Product");
                System.out.println("2. Add New Product");
                System.out.println("3. Delete Product");
                System.out.println("4. Search Product");
                System.out.println("5. Exit");
                System.out.println("Input your choice");
                int choice = choiceNumberException();
                switch (choice){
                    case 1:
                        new ProductServiceImpl().display();
                        break;
                    case 2:
                        new ProductServiceImpl().add();
                        break;
                    case 3:
                        new ProductServiceImpl().delete();
                        break;
                    case 4:
                        new ProductServiceImpl().search();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("???????");
                }
            }
        }
    }
}
