package ru.geekbrains.persist;


public class Product {

    private Long id;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String productName;


    public Product() {
    }

    public Product(String productName1) {
        this.productName = productName1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
