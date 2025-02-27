package com.lzi.Custeemizer.Common;


import javax.persistence.*;

@Entity
@Table(name="tshirt")
public class Tshirt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable = false)
    private long tshirt_ID;

    private String name;
    private String sex;
    private String color;
    private String description;
    private String image_URL;
    private String logo_URL;
    private String cust_text;
    private double price;
    private Boolean customized;

    public Tshirt(String name, String sex, String color, String description, String image_URL, double price, Boolean customized) {
        this.name = name;
        this.sex = sex;
        this.color = color;
        this.price = price;
        this.customized = customized;
        this.description = description;
        this.image_URL = image_URL;
    }

    public Tshirt(){}

    public String getImage_URL() {
        return image_URL;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }

    public long getTshirt_ID() {
        return tshirt_ID;
    }

    public void setTshirt_ID(long tshirt_ID) {
        this.tshirt_ID = tshirt_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getCustomized() {
        return customized;
    }

    public void setCustomized(Boolean customized) {
        this.customized = customized;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo_URL() {
        return logo_URL;
    }

    public void setLogo_URL(String logo_URL) {
        this.logo_URL = logo_URL;
    }

    public String getCust_text() {
        return cust_text;
    }

    public void setCust_text(String cust_text) {
        this.cust_text = cust_text;
    }
}
