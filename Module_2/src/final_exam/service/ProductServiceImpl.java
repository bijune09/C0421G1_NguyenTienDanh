package final_exam.service;

import final_exam.controller.ProductManagement;
import final_exam.libs.MyCheckRegex;
import final_exam.libs.ReadAndWrite;
import final_exam.models.ExportProduct;
import final_exam.models.ImportProduct;
import final_exam.models.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductServiceImpl extends MyCheckRegex implements ProductService {
    public static List<Product> myListProduct = new LinkedList<>();
    private static boolean check = false;
    private static final String FILE_PATH_EXPORT =
            "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\final_exam\\data\\exportProduct.csv";
    private static final String FILE_PATH_IMPORT =
            "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\final_exam\\data\\importProduct.csv";
    private static ReadAndWrite readAndWrite = new ReadAndWrite();

    public List<Product> readFileFromCSV() {
        List<Product> arrayFromFile = new LinkedList<>();
        List<String> lineImport = readAndWrite.readFile(FILE_PATH_IMPORT);
        for (String line : lineImport) {
            String[] splitLine = line.split(",");
            ImportProduct importProduct = new ImportProduct(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2],
                    Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]), splitLine[5],
                    Double.parseDouble(splitLine[6]), splitLine[7], Integer.parseInt(splitLine[8]));
            arrayFromFile.add(importProduct);
        }
        List<String> lineExport = readAndWrite.readFile(FILE_PATH_EXPORT);
        for (String line : lineExport) {
            String[] splitLine = line.split(",");
            ExportProduct exportProduct = new ExportProduct(Integer.parseInt(splitLine[0]), splitLine[1]
                    , splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]), splitLine[5],
                    Double.parseDouble(splitLine[6]), splitLine[7]);
            arrayFromFile.add(exportProduct);
        }
        return arrayFromFile;
    }

    @Override
    public void add() {
        while (true) {
            System.out.println("----Add New Product Menu------");
            System.out.println("1. Add new Import Product");
            System.out.println("2. Add new Export Product");
            System.out.println("3. Return Menu");
            System.out.println("Your choice");
            int choice = choiceNumberException();
            switch (choice) {
                case 1:
                    addImportProduct();
                    break;
                case 2:
                    addExportProduct();
                    break;
                case 3:
                    new ProductManagement().displayProductManagement();
                default:
                    System.out.println("Try again");
            }
        }
    }


    private void writeProduct() {
        String writeProduct;
        for (Product product : myListProduct) {
            if (product instanceof ExportProduct) {
                writeProduct = product.getIdProduct() + "," + product.getCodeProduct() + "," + product.getNameProduct()
                        + "," + product.getPrice() + "," + product.getAmount() + "," + product.getProducer() +
                        "," + ((ExportProduct) product).getExportPrice() + "," +
                        ((ExportProduct) product).getCountryImport();
                readAndWrite.writeFile(FILE_PATH_EXPORT, writeProduct, true);
            }
            if (product instanceof ImportProduct) {
                writeProduct = product.getIdProduct() + "," + product.getCodeProduct() + "," + product.getNameProduct()
                        + "," + product.getPrice() + "," + product.getAmount() + "," + product.getProducer() +
                        "," + ((ImportProduct) product).getImportPrice() + "," +
                        ((ImportProduct) product).getProvinceImport() + "," + ((ImportProduct) product).getImportTax();
                readAndWrite.writeFile(FILE_PATH_IMPORT, writeProduct, true);
            }
        }
    }

    @Override
    public void delete() {
        myListProduct = readFileFromCSV();
        System.out.println("Input ID you wanna delete");
        int id = choiceNumberException();
        for (Product product : myListProduct) {
            if (product.getIdProduct() == id) {
                myListProduct.remove(product);
                System.out.println("Product has been remove");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("ID not found");
        } else {
            readAndWrite.deleteContentFromCSV(FILE_PATH_EXPORT);
            readAndWrite.deleteContentFromCSV(FILE_PATH_IMPORT);
            writeProduct();
        }
    }

    @Override
    public void display() {
        myListProduct = readFileFromCSV();
        if (myListProduct.isEmpty()) {
            System.out.println("Nothing");
        } else {
            for (Product product : myListProduct) {
                System.out.println(product);
            }
        }
    }

    @Override
    public void search() {
        myListProduct = readFileFromCSV();
        System.out.println("Input ID you wanna find");
        int id = choiceNumberException();
        for (Product product : myListProduct) {
            if (product.getIdProduct() == id) {
                System.out.println(product);
                check = true;
            }
        }
        if (!check) {
            System.out.println("ID not found");
        }
    }

    @Override
    public void addImportProduct() {
        myListProduct = readFileFromCSV();
        int id;
        if (myListProduct.isEmpty()) {
            id = 1;
        } else {
            id = myListProduct.get(myListProduct.size() - 1).getIdProduct() + 1;
        }
        System.out.println("Input Code Product. Example: SP-XXXX, X is number");
        String codeProduct = checkLoop(REGEX_CODE_PRODUCT, input().nextLine());
        System.out.println("Input Name Product. (Iphone,Rolex,Adidas)");
        String nameProduct = checkLoop(REGEX_IMPORT_PRODUCT, input().nextLine());
        System.out.println("Input Price Product");
        double price = Double.parseDouble(checkLoop(REGEX_AMOUNT, input().nextLine()));
        System.out.println("Input Amount Product");
        int amount = Integer.parseInt(checkLoop(REGEX_PRICE, input().nextLine()));
        System.out.println("Input Producer of Product");
        String producer = checkLoop(REGEX_COUNTRY, input().nextLine());
        System.out.println("Input Import Price Product");
        double importPrice = Double.parseDouble(checkLoop(REGEX_AMOUNT, input().nextLine()));
        System.out.println("Input Province Import Product");
        String provinceImport = checkLoop(REGEX_NAME, input().nextLine());
        System.out.println("Input Import Tax Product");
        int importTax = Integer.parseInt(checkLoop(REGEX_PRICE, input().nextLine()));
        String line = id + "," + codeProduct + "," + nameProduct + "," + price + "," + amount + "," + producer +
                "," + importPrice + "," + provinceImport + "," + importTax;
        System.out.println("Success");
        readAndWrite.writeFile(FILE_PATH_IMPORT, line, true);
    }

    @Override
    public void addExportProduct() {
        myListProduct = readFileFromCSV();
        int id;
        if (myListProduct.isEmpty()) {
            id = 1;
        } else {
            id = myListProduct.get(myListProduct.size() - 1).getIdProduct() + 1;
        }
        System.out.println("Input Code Product. Example: SP-XXXX. X is number");
        String codeProduct = checkLoop(REGEX_CODE_PRODUCT, input().nextLine());
        System.out.println("Input Name Product. (Ao Dai, Gao)");
        String nameProduct = checkLoop(REGEX_EXPORT_PRODUCT, input().nextLine());
        System.out.println("Input Price Product");
        double price = Double.parseDouble(checkLoop(REGEX_AMOUNT, input().nextLine()));
        System.out.println("Input Amount Product");
        int amount = Integer.parseInt(checkLoop(REGEX_PRICE, input().nextLine()));
        System.out.println("Input Producer of Product");
        String producer = checkLoop(REGEX_NAME, input().nextLine());
        System.out.println("Input Export Price Product");
        double exportPrice = Double.parseDouble(checkLoop(REGEX_AMOUNT, input().nextLine()));
        System.out.println("Input Country Import Product");
        String countryImport = checkLoop(REGEX_COUNTRY, input().nextLine());
        String line = id + "," + codeProduct + "," + nameProduct + "," + price + "," +
                amount + "," + producer + "," + exportPrice + "," + countryImport;
        System.out.println("Success");
        readAndWrite.writeFile(FILE_PATH_EXPORT, line, true);
    }
}
