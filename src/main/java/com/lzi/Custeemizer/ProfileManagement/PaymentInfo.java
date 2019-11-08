package com.lzi.Custeemizer.ProfileManagement;


import com.lzi.Custeemizer.Common.Customer;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class PaymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable = false)
    private long payment_ID;

    private String cc_number;
    private String cc_firstname;
    private String cc_lastname;
    private String cc_type;
    private String cc_address;
    private String cc_expiry;

    @OneToOne
    @JoinColumn(name="customer_ID")
    private Customer customer;

    public PaymentInfo(String cc_number, String cc_expiry, String cc_firstname, String cc_lastname, String cc_type, String cc_address, Customer customer) {
        this.cc_number = cc_number;
        this.cc_firstname = cc_firstname;
        this.cc_lastname = cc_lastname;
        this.cc_type = cc_type;
        this.cc_address = cc_address;
        this.customer = customer;
        this.cc_expiry = cc_expiry;
    }
    public PaymentInfo(String cc_number, String cc_expiry, String cc_firstname, String cc_lastname, String cc_type, String cc_address) {
        this.cc_number = cc_number;
        this.cc_firstname = cc_firstname;
        this.cc_lastname = cc_lastname;
        this.cc_type = cc_type;
        this.cc_address = cc_address;
        this.cc_expiry = cc_expiry;
    }
    public PaymentInfo(){}

    public long getPayment_ID() {
        return payment_ID;
    }

    public void setPayment_ID(long payment_ID) {
        this.payment_ID = payment_ID;
    }

    public String getCc_number() {
        return cc_number;
    }

    public void setCc_number(String cc_number) {
        this.cc_number = cc_number;
    }

    public String getCc_firstname() {
        return cc_firstname;
    }

    public void setCc_firstname(String cc_firstname) {
        this.cc_firstname = cc_firstname;
    }

    public String getCc_lastname() {
        return cc_lastname;
    }

    public void setCc_lastname(String cc_lastname) {
        this.cc_lastname = cc_lastname;
    }

    public String getCc_type() {
        return cc_type;
    }

    public void setCc_type(String cc_type) {
        this.cc_type = cc_type;
    }

    public String getCc_address() {
        return cc_address;
    }

    public void setCc_address(String cc_address) {
        this.cc_address = cc_address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCc_expiry() {
        return cc_expiry;
    }

    public void setCc_expiry(String cc_expiry) {
        this.cc_expiry = cc_expiry;
    }
}
