package com.lzi.Custeemizer.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    public User(String email, String password, String first_name, String last_name, Boolean admin) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.admin = admin;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long user_ID;

    private String email, password, first_name, last_name;
    private Boolean admin;

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
