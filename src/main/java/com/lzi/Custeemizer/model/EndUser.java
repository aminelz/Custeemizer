package com.lzi.Custeemizer.model;

import javax.persistence.*;

@Entity
@Table(name="enduser")
public class EndUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long user_ID;

    private String email, password, first_name, last_name;
    private Boolean admin;

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
