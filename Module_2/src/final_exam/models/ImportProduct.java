package final_exam.models;

public class ImportProduct extends Product {
    private double importPrice;
    private String provinceImport;
    private int importTax;

    public ImportProduct() {
    }

    public ImportProduct(int idProduct, String codeProduct, String nameProduct, double price, int amount,
                         String producer, double importPrice, String provinceImport, int importTax) {
        super(idProduct, codeProduct, nameProduct, price, amount, producer);
        this.importPrice = importPrice;
        this.provinceImport = provinceImport;
        this.importTax = importTax;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getProvinceImport() {
        return provinceImport;
    }

    public void setProvinceImport(String provinceImport) {
        this.provinceImport = provinceImport;
    }

    public int getImportTax() {
        return importTax;
    }

    public void setImportTax(int importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return super.toString() + ", importPrice=" + importPrice + ", provinceImport=" + provinceImport + ", " +
                "importTax=" + importTax;
    }
}
