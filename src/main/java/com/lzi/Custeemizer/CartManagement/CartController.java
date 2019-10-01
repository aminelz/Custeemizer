package com.lzi.Custeemizer.CartManagement;

import com.lzi.Custeemizer.Common.Tshirt;
import com.lzi.Custeemizer.Common.TshirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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










}
