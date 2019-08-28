package com.lzi.Custeemizer.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity //Defines that class will be maped to table (JPA)
@Table(name="customer") //Defines class as Table and names it "customer" to avoid it inheriting the class name
public class UserCustomer {

    @Id //Indicates that the next attribute will be used as primary key for the table
    @GeneratedValue(strategy= GenerationType.AUTO) //Generates a unique value for our attribute
    private long customer_ID;

    private String birth_date, address, phone_number;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) //CascadeType.ALL means that if UserCustomer is deleted, User is as well.
    @JsonIgnore
    @JoinColumn(name = "user_ID") //Defining which column will be used as common key
    //@MapsId //indicates that both tables will have the same primary key
    private EndUser endUser; //Tables to apply relationship with

    public UserCustomer(String birth_date, String address, String phone_number, EndUser endUser) {
        this.birth_date = birth_date;
        this.address = address;
        this.phone_number = phone_number;
        this.endUser = endUser;
    }
    public UserCustomer(){}

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }
}
