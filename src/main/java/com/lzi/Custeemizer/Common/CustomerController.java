package com.lzi.Custeemizer.Common;

import com.lzi.Custeemizer.Authentication.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository custrepo; //Asking spring to create instance of CustomerRepo to be able to use the given data manipulation methods

    @RequestMapping("/Customerss")
    public List<Customer> getCustomers(){
        return custrepo.findCustomers();
    }


//    @RequestMapping("/Customers")
//    public List<Object[]> getAllCustomers(){
//        return custrepo.findAllCustomers();
//    }

    @RequestMapping("/Customer/{id}")
    public Customer getCustomerInfo(@PathVariable(value="id") long id){
        return custrepo.findCustomer(id);
    }




}
