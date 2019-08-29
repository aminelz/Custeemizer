package com.lzi.Custeemizer.model;


import javax.persistence.*;

@Entity
@Table(name="cartitem")
public class CartItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long item_id;

    private int quantity;
    private double total_price;

    @OneToOne
    @JoinColumn(name = "tshirt")
    private Tshirt tshirt;

    @ManyToOne
    @JoinColumn(name="cart")
    private Cart cart;

    public Tshirt getTshirt() {
        return tshirt;
    }

    public void setTshirt(Tshirt tshirt) {
        this.tshirt = tshirt;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}
