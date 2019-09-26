package com.lzi.Custeemizer.Common;

import com.lzi.Custeemizer.Authentication.EndUser;
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

    @RequestMapping("/Customers")
    public List<Object[]> getAllCustomers(){
        return userrepo.findAllCustomers();
    }

    @RequestMapping("/userofcustomer/{id}")
    public List<Object[]> getUserofCustomer(@PathVariable(value="id") Long id){
        return userrepo.findUserByCustomer(id);
    }

    @RequestMapping("/Customers/{id}")
    public List<Object[]> getCustomerById(@PathVariable(value="id") Long id) {
        return userrepo.findCustomerById(id);
    }


//    public Iterable<Customer> getCustomers(){
//        return custrepo.findAll();
//    }

//    @RequestMapping("/listadmins")


}
