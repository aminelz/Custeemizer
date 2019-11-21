package com.lzi.Custeemizer.CartManagement;

public class NewCartItem {

    private long tshirt_ID;
    private int quantity;
    private String size;
    private long cart_ID;

    public NewCartItem() {
    }

    public long getTshirt_ID() {
        return tshirt_ID;
    }

    public void setTshirt_ID(long tshirt_ID) {
        this.tshirt_ID = tshirt_ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public long getCart_ID() {
        return cart_ID;
    }

    public void setCart_ID(long cart_ID) {
        this.cart_ID = cart_ID;
    }
}
