package com.lzi.Custeemizer.model;


import javax.persistence.*;

@Entity
@Table(name="order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long order_ID;

    private String processed;
    private double total_price;

    @OneToOne
    @JoinColumn(name="customer_ID")
    private UserCustomer customer;

}

