package com.lzi.Custeemizer.controller;

import com.lzi.Custeemizer.model.Cart;
import com.lzi.Custeemizer.repository.CartRepository;
import com.lzi.Custeemizer.repository.TshirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class CartController {

    @Autowired
    CartRepository cartrepo;

    @Autowired
    TshirtRepository tshirtrepo;

    @RequestMapping("/Cart/{id}")
    public Cart getCartbyID(@PathVariable(value="id") Long id){
        return cartrepo.findTotalByCart_ID(id);
    }

    @RequestMapping("/Carts")
    public Iterable<Cart> getallCarts(){ return cartrepo.findAll();}










}
