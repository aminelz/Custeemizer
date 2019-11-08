package com.lzi.Custeemizer.ProfileManagement;

import com.lzi.Custeemizer.Authentication.EndUser;
import com.lzi.Custeemizer.Common.Customer;

public class RegistrationForm{

    private String user_firstname, user_lastname, user_email, user_password;
    private String customer_birthdate, customer_phonenumber;
    private String payment_number;
    private String payment_firstname;
    private String payment_lastname;
    private String payment_type;
    private String payment_address;
    private String payment_expiry;
    private String shipping_street, shipping_zipcode,  shipping_city, shipping_country;

    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }


    public String getCustomer_birthdate() {
        return customer_birthdate;
    }

    public void setCustomer_birthdate(String customer_birthdate) {
        this.customer_birthdate = customer_birthdate;
    }

    public String getCustomer_phonenumber() {
        return customer_phonenumber;
    }

    public void setCustomer_phonenumber(String customer_phonenumber) {
        this.customer_phonenumber = customer_phonenumber;
    }

    public String getPayment_number() {
        return payment_number;
    }

    public void setPayment_number(String payment_number) {
        this.payment_number = payment_number;
    }

    public String getPayment_firstname() {
        return payment_firstname;
    }

    public void setPayment_firstname(String payment_firstname) {
        this.payment_firstname = payment_firstname;
    }

    public String getPayment_lastname() {
        return payment_lastname;
    }

    public void setPayment_lastname(String payment_lastname) {
        this.payment_lastname = payment_lastname;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getPayment_address() {
        return payment_address;
    }

    public void setPayment_address(String payment_address) {
        this.payment_address = payment_address;
    }

    public String getPayment_expiry() {
        return payment_expiry;
    }

    public void setPayment_expiry(String payment_expiry) {
        this.payment_expiry = payment_expiry;
    }

    public String getShipping_street() {
        return shipping_street;
    }

    public void setShipping_street(String shipping_street) {
        this.shipping_street = shipping_street;
    }

    public String getShipping_zipcode() {
        return shipping_zipcode;
    }

    public void setShipping_zipcode(String shipping_zipcode) {
        this.shipping_zipcode = shipping_zipcode;
    }

    public String getShipping_city() {
        return shipping_city;
    }

    public void setShipping_city(String shipping_city) {
        this.shipping_city = shipping_city;
    }

    public String getShipping_country() {
        return shipping_country;
    }

    public void setShipping_country(String shipping_country) {
        this.shipping_country = shipping_country;
    }


    //    public RegistrationForm(String user_firstname, String user_lastname, String user_email, String user_password, String user_admin, String customer_birthdate, String customer_phonenumber, String payment_number, String payment_firstname, String payment_lastname, String payment_type, String payment_address, String payment_expiry, String shipping_street, String shipping_zipcode, String shipping_city, String shipping_country) {
//        this.user_firstname = user_firstname;
//        this.user_lastname = user_lastname;
//        this.user_email = user_email;
//        this.user_password = user_password;
//        this.user_admin = user_admin;
//        this.customer_birthdate = customer_birthdate;
//        this.customer_phonenumber = customer_phonenumber;
//        this.payment_number = payment_number;
//        this.payment_firstname = payment_firstname;
//        this.payment_lastname = payment_lastname;
//        this.payment_type = payment_type;
//        this.payment_address = payment_address;
//        this.payment_expiry = payment_expiry;
//        this.shipping_street = shipping_street;
//        this.shipping_zipcode = shipping_zipcode;
//        this.shipping_city = shipping_city;
//        this.shipping_country = shipping_country;
//    }

    public RegistrationForm() {
    }

//    public EndUser getUser(){
//        return new EndUser(user_email, user_password, user_firstname, user_lastname, Boolean.FALSE);
//    }
//
//    public Customer getCustomer(){
//        return new Customer(customer_birthdate, customer_phonenumber);
//    }
//
//    public PaymentInfo getPayment(){
//        return new PaymentInfo(payment_number, payment_expiry, payment_firstname, payment_lastname, payment_type, payment_address);
//    }
//
//    public ShippingInfo getShipping(){
//        return new ShippingInfo(shipping_street, shipping_zipcode,  shipping_city, shipping_country);
//    }
}

