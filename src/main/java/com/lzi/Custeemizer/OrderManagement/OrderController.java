package com.lzi.Custeemizer.OrderManagement;


import com.lzi.Custeemizer.CartManagement.*;
import com.lzi.Custeemizer.Common.CustomerRepository;
import com.lzi.Custeemizer.Common.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    OrderRepository orderrepo;

    @Autowired
    CartItemRepository itemrepo;

    @Autowired
    CartRepository cartrepo;

    @Autowired
    CustomerRepository custrepo;


    @RequestMapping("/Orders")
    public List<Order> getAllOrders(){ return orderrepo.findAllOrders();}

    @RequestMapping("/Orders/customer={id}")
    public List<Order> getOrdersofCustomer(@PathVariable(value= "id") long id){
        return orderrepo.findOrderByCustomer(id);
    }
    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/NewOrder")
    public void addNewItem(@RequestBody NewOrder newOrder){
        double price = newOrder.getTotal();
        long customerid = newOrder.getCustomer_id();
        long cartid = newOrder.getCart_id();
        cartrepo.changeTotalPrice(cartid, price);
//        cartrepo.setTotalPrice(price, cartid);
        Order neworder = new Order("Order Received", price, custrepo.findCustomer(customerid), cartrepo.findcartByID(cartid), LocalDateTime.now());
        orderrepo.save(neworder);
    }






}
