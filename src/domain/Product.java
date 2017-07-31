package domain;


public class Product {
    private int productId;
    private String productName;
    private int productPrice;
    private int quantity;


    public Product() {
    }

public Product(int productId, String productName, int quantity, int unitPrice) {
    this.productId = productId;
    this.productName = productName;
    this.quantity = quantity;
    this.productPrice = unitPrice;
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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
