package com.stock.manage;

public class Stock {
    private String product;
    private int quantity;
    private int itemCode;
    private int price;

    public String getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getItemCode() {
        return itemCode;
    }
    public int getPrice() {
        return price;
    }

    public Stock(String product, int quantity, int itemCode, int price) {
        this.product = product;
        this.quantity = quantity;
        this.itemCode = itemCode;
        this.price = price;
    }
    public Stock(){}

    @Override
    public String toString() {
        return "Stock{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", itemCode=" + itemCode +
                ", price=" + price +
                '}';
    }
}
