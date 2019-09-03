package com.lzi.Custeemizer.model;


import javax.persistence.*;

@Entity
@Table(name="payment")
public class PaymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long payment_ID;

    private String cc_number, cc_firstname, cc_lastname, cc_type, cc_address;

    @OneToOne
    @JoinColumn(name="customer_ID")
    private UserCustomer customer;

    public PaymentInfo(String cc_number, String cc_firstname, String cc_lastname, String cc_type, String cc_address, UserCustomer customer) {
        this.cc_number = cc_number;
        this.cc_firstname = cc_firstname;
        this.cc_lastname = cc_lastname;
        this.cc_type = cc_type;
        this.cc_address = cc_address;
        this.customer = customer;
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

    public UserCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(UserCustomer customer) {
        this.customer = customer;
    }
}
