package com.lzi.Custeemizer.CartManagement;

import com.lzi.Custeemizer.Common.TshirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CartController {

    @Autowired
    CartRepository cartrepo;

    @Autowired
    TshirtRepository tshirtrepo;

    @RequestMapping("/Cart16")
    public Cart getCartbyID(){
        return cartrepo.findCartById(16);
    }

    @RequestMapping("/Carts")
    public Iterable<Cart> getallCarts(){ return cartrepo.findAll();}










}
