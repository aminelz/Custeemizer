package com.lzi.Custeemizer.model;


import javax.persistence.*;

@Entity
@Table(name="cartitem")
public class CartItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long item_ID;

    private int quantity;

    @OneToOne
    @JoinColumn(name = "tshirt_ID")
    private Tshirt tshirt;


    public long getItem_ID() {
        return item_ID;
    }

    public void setItem_ID(long item_ID) {
        this.item_ID = item_ID;
    }


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

}
