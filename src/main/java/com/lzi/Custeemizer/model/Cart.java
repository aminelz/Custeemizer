package com.lzi.Custeemizer.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cart_ID;

    private Date creation_time;
    private double Total;

    @OneToMany
    //@JoinColumn(name="item_ID")
    private List<CartItem> items;


    public long getCart_ID() {
        return cart_ID;
    }

    public void setCart_ID(long cart_ID) {
        this.cart_ID = cart_ID;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
}
