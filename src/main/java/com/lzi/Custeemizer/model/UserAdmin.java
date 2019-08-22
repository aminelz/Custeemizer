package com.lzi.Custeemizer.model;


import javax.persistence.*;

@Entity
@Table(name="admin")
public class UserAdmin {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long admin_ID;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID")
    @MapsId
    private User user;

    private String permission;

    public UserAdmin(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
