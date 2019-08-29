package com.lzi.Custeemizer.model;


import javax.persistence.*;

@Entity
@Table(name="tshirt")
public class Tshirt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tshirt_ID;

    private String name, sex, size, color, description;
    private double price;
    private Boolean customized;

    public Tshirt(String name, String sex, String size, String color, String description, double price, Boolean customized) {
        this.name = name;
        this.sex = sex;
        this.size = size;
        this.color = color;
        this.price = price;
        this.customized = customized;
        this.description = description;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
}
