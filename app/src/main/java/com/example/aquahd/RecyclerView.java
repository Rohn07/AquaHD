package com.example.aquahd;

public class RecyclerView {

    private String product_view;
    private String product_price;
    private String product;
    private String permission;

    public RecyclerView() {
    }

    public RecyclerView(String product_view, String product_price, String product, String permission) {
        this.product_view = product_view;
        this.product_price = product_price;
        this.product = product;
        this.permission = permission;
    }

    public String getProduct_view() {
        return product_view;
    }

    public void setProduct_view(String product_view) {
        this.product_view = product_view;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }


}
