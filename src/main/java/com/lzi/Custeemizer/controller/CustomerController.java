package com.lzi.Custeemizer.controller;

import com.lzi.Custeemizer.model.EndUser;
import com.lzi.Custeemizer.model.UserCustomer;
import com.lzi.Custeemizer.repository.CustomerRepository;
import com.lzi.Custeemizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository custrepo; //Asking spring to create instance of CustomerRepo to be able to use the given data manipulation methods
    @Autowired
    private UserRepository userrepo;

    @RequestMapping("/listofcustomers")
    public List<EndUser> getCustomers(){
        return userrepo.findbyAdmin(false);
    }

    @RequestMapping("/listofadmins")
    public List<EndUser> getAdmins(){
        return userrepo.findbyAdmin(true);
    }

    @RequestMapping("/fulllistofcustomers")
    public List<Object[]> getAllCustomers(){
        return userrepo.findAllCustomers();
    }

    @RequestMapping("/userofcustomer/{id}")
    public List<Object[]> getUserofCustomer(@PathVariable(value="id") Long id){
        return userrepo.findUserByCustomer(id);
    }

//    public Iterable<UserCustomer> getCustomers(){
//        return custrepo.findAll();
//    }

//    @RequestMapping("/listadmins")


}
