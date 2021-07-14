package final_exam.models;

public class ExportProduct extends Product {
    private double exportPrice;
    private String countryImport;

    public ExportProduct() {
    }

    public ExportProduct(int idProduct, String codeProduct, String nameProduct, double price, int amount,
                         String producer, double exportPrice, String countryImport) {
        super(idProduct, codeProduct, nameProduct, price, amount, producer);
        this.exportPrice = exportPrice;
        this.countryImport = countryImport;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getCountryImport() {
        return countryImport;
    }

    public void setCountryImport(String countryImport) {
        this.countryImport = countryImport;
    }

    @Override
    public String toString() {
        return super.toString()+", exportPrice="+exportPrice+", countryImport="+countryImport;
    }
}
