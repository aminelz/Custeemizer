package com.lzi.Custeemizer.ProfileManagement;


import com.lzi.Custeemizer.Common.Customer;

import javax.persistence.*;

@Entity
@Table(name="shipping")
public class ShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable = false)
    private long shipping_ID;

    private String street, zipcode,  city, country;

    @OneToOne
    @JoinColumn(name="customer_ID")
    private Customer customer;

    public ShippingInfo(String street, String zipcode, String city, String country, Customer customer) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.customer = customer;
    }
    public ShippingInfo(String street, String zipcode, String city, String country) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
    }
    public ShippingInfo(){}

    public long getShipping_ID() {
        return shipping_ID;
    }

    public void setShipping_ID(long shipping_ID) {
        this.shipping_ID = shipping_ID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
