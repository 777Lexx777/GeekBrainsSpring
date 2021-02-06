package ru.geekbrains.model;

import org.springframework.stereotype.Component;

@Component
public class Product { //implements UserDetails

    private long id;
    private String nameProduct ;
    private int price;

    public Product() {
    }

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
