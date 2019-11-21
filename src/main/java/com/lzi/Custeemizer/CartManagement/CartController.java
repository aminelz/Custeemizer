package com.lzi.Custeemizer.CartManagement;

import com.lzi.Custeemizer.Common.Tshirt;
import com.lzi.Custeemizer.Common.TshirtRepository;
import com.lzi.Custeemizer.OrderManagement.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
public class CartController {

    @Autowired
    CartRepository cartrepo;

    @Autowired
    TshirtRepository tshirtrepo;

    @Autowired
    CartItemRepository itemrepo;

    @Autowired
    OrderRepository orderepo;

    @CrossOrigin
    @RequestMapping("/Cart/{id}")
    public Optional<Cart> getCartbyID(@PathVariable(value ="id") long id){
        return cartrepo.findById(id);
    }
//    @CrossOrigin
//    @RequestMapping("/Cart/{id}/Tshirts")
//    public Iterable<Tshirt> getTshirtsByCartID(){
//        return null;
//    }
    @CrossOrigin
    @RequestMapping("/Carts")
    public Iterable<Cart> getallCarts(){ return cartrepo.findAll();}

    @CrossOrigin
    @RequestMapping("/Cart/{id}/items")
    public List<CartItem> getCartItems(@PathVariable(value="id") long id){
        return itemrepo.getAllItems(id);
    }

    @CrossOrigin
    @RequestMapping("/Order/{id}/items")
    public List<CartItem> getOrderItems(@PathVariable(value="id") long id){
        System.out.println("Order Id : " +id);
        long cartid = orderepo.findCartByOrder(id);
        System.out.println("Cart ID : " +cartid);
        return itemrepo.getAllItems(cartid);
    }

    @CrossOrigin
    @RequestMapping("/NewCart")
    public Cart getNewCartID(){
        long lastcart_ID = cartrepo.findIDoflastCart();
        System.out.println(lastcart_ID);
        int count = itemrepo.findCartCount(lastcart_ID);
        System.out.println(count);
        if(count == 0 ){
            cartrepo.deleteById(lastcart_ID);
        }
        Cart newcart = new Cart(LocalDateTime.now(), 0);
        cartrepo.save(newcart);
        return newcart;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/NewCartItem")
    public void addNewItem(@RequestBody NewCartItem newCartItem){
        int newitem_quantity = newCartItem.getQuantity();
        String newitem_size = newCartItem.getSize();
        Tshirt addedtshirt = tshirtrepo.findTshirtByID(newCartItem.getTshirt_ID());
        Cart usedcart = cartrepo.findcartByID(newCartItem.getCart_ID());
        CartItem newitem = new CartItem(newitem_quantity, newitem_size, addedtshirt, usedcart);
        itemrepo.save(newitem);
    }

    @CrossOrigin
    @RequestMapping("/CartItem/{id}/Delete")
    public void deleteItem(@PathVariable(value="id") long id){
        itemrepo.deleteById(id);
    }



}
