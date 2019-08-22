package com.lzi.Custeemizer.model;


import javax.persistence.*;

@Entity
@Table(name="customer")
public class UserCustomer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long customer_ID;

    private String birth_date, address, phone_number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID")
    private User user;

    public UserCustomer(String birth_date, String address, String phone_number) {
        this.birth_date = birth_date;
        this.address = address;
        this.phone_number = phone_number;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
