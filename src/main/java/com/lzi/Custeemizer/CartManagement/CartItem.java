package com.lzi.Custeemizer.CartManagement;


import com.lzi.Custeemizer.Common.Tshirt;

import javax.persistence.*;

@Entity
@Table(name="cartitem")
public class CartItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable = false)
    private long item_ID;

    private int quantity;
    private String size;



    @OneToOne
    @JoinColumn(name = "tshirt_ID")
    private Tshirt tshirt;

    @ManyToOne
    @JoinColumn(name="cart_ID")
    private Cart mycart;

    public CartItem(int quantity, String size, Tshirt tshirt,  Cart cart) {
        this.quantity = quantity;
        this.tshirt = tshirt;
        this.mycart = cart;
        this.size = size;
    }
    public CartItem(){}

    public Cart getcart() {
        return mycart;
    }

    public void setcart(Cart cart) {
        this.mycart = cart;
    }

    public long getItem_ID() {
        return item_ID;
    }

    public void setItem_ID(long item_ID) {
        this.item_ID = item_ID;
    }


    public Tshirt getTshirt() {
        return tshirt;
    }

    public void setTshirt(Tshirt tshirt) {
        this.tshirt = tshirt;
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

}
