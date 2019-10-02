package com.lzi.Custeemizer.OrderManagement;


import com.fasterxml.jackson.annotation.*;
import com.lzi.Custeemizer.CartManagement.Cart;
import com.lzi.Custeemizer.Common.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="torder")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "order_ID")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable = false)
    private long order_ID;

    private String processed;
    private double total_price;
    private LocalDateTime creation_time;

    @ManyToOne
    @JoinColumn(name="customer_ID")
    private Customer mycustomer;

    @OneToOne
    @JoinColumn(name="cart_ID")
    private Cart mycart;

    public Order(String processed, double total_price, Customer customer, Cart mycart, LocalDateTime time) {
        this.processed = processed;
        this.total_price = total_price;
        this.mycustomer = customer;
        this.mycart = mycart;
        this.creation_time = time;
    }
    public Order(){}

    public LocalDateTime getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(LocalDateTime creation_time) {
        this.creation_time = creation_time;
    }

    public Cart getMycart() {
        return mycart;
    }

    public void setMycart(Cart mycart) {
        this.mycart = mycart;
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

