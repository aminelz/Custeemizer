package com.lzi.Custeemizer.OrderManagement;


import com.lzi.Custeemizer.CartManagement.Cart;
import com.lzi.Custeemizer.Common.Customer;

import javax.persistence.*;

@Entity
@Table(name="torder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable = false)
    private long order_ID;

    private String processed;
    private double total_price;

    @ManyToOne
    @JoinColumn(name="customer_ID")
    private Customer mycustomer;

    @OneToOne
    @JoinColumn(name="cart_ID")
    private Cart cart;

    public Order(String processed, double total_price, Customer customer, Cart cart) {
        this.processed = processed;
        this.total_price = total_price;
        this.mycustomer = customer;
        this.cart = cart;
    }
    public Order(){}

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public long getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(long order_ID) {
        this.order_ID = order_ID;
    }

    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Customer getCustomer() {
        return mycustomer;
    }

    public void setCustomer(Customer customer) {
        this.mycustomer = customer;
    }
}

