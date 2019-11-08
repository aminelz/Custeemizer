package com.lzi.Custeemizer.Common;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lzi.Custeemizer.Authentication.EndUser;
import com.lzi.Custeemizer.OrderManagement.Order;
import com.lzi.Custeemizer.ProfileManagement.PaymentInfo;
import com.lzi.Custeemizer.ProfileManagement.ShippingInfo;

import javax.persistence.*;
import java.util.List;

@Entity //Defines that class will be maped to table (JPA)
@Table(name="customer") //Defines class as Table and names it "customer" to avoid it inheriting the class name
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "customer_ID")
public class Customer {

    @Id //Indicates that the next attribute will be used as primary key for the table
    @GeneratedValue(strategy= GenerationType.AUTO) //Generates a unique value for our attribute
    @Column(nullable=false, updatable = false)
    private long customer_ID;

    private String birth_date;
    private String phone_number;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) //CascadeType.ALL means that if Customer is deleted, User is as well.
    @JsonIgnore
    @JoinColumn(name = "user_ID") //Defining which column will be used as common key
    //@MapsId //indicates that both tables will have the same primary key
    private EndUser myendUser; //Tables to apply relationship with

    @OneToOne
    @JoinColumn(name="shipping_ID")
    private ShippingInfo shipping;

    @OneToOne
    @JoinColumn(name = "payment_ID")
    private PaymentInfo payment;

    @OneToMany(mappedBy = "mycustomer")
    //@JoinColumn(name="order_ID")
    private List<Order> orders;

    public Customer(String birth_date, String phone_number, EndUser myendUser) {
        this.birth_date = birth_date;
        this.phone_number = phone_number;
        this.myendUser = myendUser;
    }
    public Customer(String birth_date, String phone_number) {
        this.birth_date = birth_date;
        this.phone_number = phone_number;
    }
    public Customer(){}

    public ShippingInfo getShipping() {
        return shipping;
    }

    public void setShipping(ShippingInfo shipping) {
        this.shipping = shipping;
    }

    public PaymentInfo getPayment() {
        return payment;
    }

    public void setPayment(PaymentInfo payment) {
        this.payment = payment;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public long getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(long customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public EndUser getMyendUser() {
        return myendUser;
    }

    public void setMyendUser(EndUser myendUser) {
        this.myendUser = myendUser;
    }
}
