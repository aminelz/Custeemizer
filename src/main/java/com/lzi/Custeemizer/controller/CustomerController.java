package com.lzi.Custeemizer.controller;

import com.lzi.Custeemizer.model.UserCustomer;
import com.lzi.Custeemizer.repository.CustomerRepository;
import com.lzi.Custeemizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository custrepo; //Asking spring to create instance of CustomerRepo to be able to use the given data manipulation methods
    @Autowired
    private UserRepository userrepo;

    @RequestMapping("/listcustomers")
    public Iterable<UserCustomer> getCustomers(){
        return custrepo.findAll();
    }


}
