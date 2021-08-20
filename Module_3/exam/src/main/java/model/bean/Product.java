package model.bean;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private int quantity;
    private String color;
    private int categoryId;

    public Product() {
    }

    public Product(int productId, String productName, double productPrice, int quantity, String color, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.color = color;
        this.categoryId = categoryId;
    }

    public Product(String productName, double productPrice, int quantity, String color, int categoryId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.color = color;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
