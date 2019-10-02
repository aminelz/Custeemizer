package com.lzi.Custeemizer.OrderManagement;


import com.lzi.Custeemizer.CartManagement.Cart;
import com.lzi.Custeemizer.CartManagement.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    OrderRepository orderrepo;

    @Autowired
    CartItemRepository itemrepo;


    @RequestMapping("/Orders")
    public List<Order> getAllOrders(){ return orderrepo.findAllOrders();}

    @RequestMapping("/Orders/customer={id}")
    public List<Order> getOrdersofCustomer(@PathVariable(value= "id") long id){
        return orderrepo.findOrderByCustomer(id);
    }




}
