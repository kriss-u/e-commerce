package com.dragomir.ecommerce.payloads;

public class CountHolder {

    private int orderedProductSize;
    private int productSize;
    private int userSize;
    private int userOrderSize;

    public CountHolder(){}

    public CountHolder(int orderedProductSize, int productSize, int userSize, int userOrderSize) {
        this.orderedProductSize = orderedProductSize;
        this.productSize = productSize;
        this.userSize = userSize;
        this.userOrderSize = userOrderSize;
    }

    public int getOrderedProductSize() {
        return orderedProductSize;
    }

    public void setOrderedProductSize(int orderedProductSize) {
        this.orderedProductSize = orderedProductSize;
    }

    public int getProductSize() {
        return productSize;
    }

    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }

    public int getUserSize() {
        return userSize;
    }

    public void setUserSize(int userSize) {
        this.userSize = userSize;
    }

    public int getUserOrderSize() {
        return userOrderSize;
    }

    public void setUserOrderSize(int userOrderSize) {
        this.userOrderSize = userOrderSize;
    }
}
