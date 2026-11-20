package workShop3;

import java.math.BigDecimal;

public class Product {
    private String sku;
    private String productName;
    private BigDecimal price;
    private String department;

    public Product(String sku,  String productName,BigDecimal price, String department) {
        this.sku = sku;
        this.price = price;
        this.productName = productName;
        this.department = department;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
