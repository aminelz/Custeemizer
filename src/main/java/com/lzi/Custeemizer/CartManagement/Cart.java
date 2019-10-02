package com.lzi.Custeemizer.CartManagement;

import com.fasterxml.jackson.annotation.*;
import com.lzi.Custeemizer.OrderManagement.Order;

import javax.persistence.*;
import java.time.LocalDateTime;;
import java.util.List;

@Entity
@Table(name="cart")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "cart_ID")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable = false)
    private long cart_ID;

    private LocalDateTime creation_time;
    private double total;

    @OneToOne(mappedBy = "mycart")
    private Order order;

//    @OneToMany(mappedBy = "mycart")
//    //@JoinColumn(name="item_ID")
//    private List<CartItem> items;

    public Cart(LocalDateTime creation_time, double total) {
        this.creation_time = creation_time;
        this.total = total;
    }
    public Cart(){}

    public long getCart_ID() {
        return cart_ID;
    }

    public void setCart_ID(long cart_ID) {
        this.cart_ID = cart_ID;
    }

//    public List<CartItem> getItems() {
//        return items;
//    }
//
//    public void setItems(List<CartItem> items) {
//        this.items = items;
//    }

    public LocalDateTime getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(LocalDateTime creation_time) {
        this.creation_time = creation_time;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void ComputeTotalPrice(List<CartItem> items){
        total = 0;
        for (CartItem item: items){
            total += item.getQuantity() * item.getTshirt().getPrice();
        }
    }
}
