package com.lzi.Custeemizer.Authentication;

import com.lzi.Custeemizer.Common.Customer;

import javax.persistence.*;

@Entity
@Table(name="enduser")
public class EndUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long user_ID;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable=false)
    String password;

    @Column(nullable=false)
    String first_name;

    @Column(nullable=false)
    String last_name;

    @Column(nullable = false)
    private Boolean admin;

    @OneToOne(mappedBy = "myendUser")
    private Customer mycustomer;

    public EndUser(String email, String password, String first_name, String last_name, Boolean admin) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.admin = admin;
    }

    public EndUser(){}

    public long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(long user_ID) {
        this.user_ID = user_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}
