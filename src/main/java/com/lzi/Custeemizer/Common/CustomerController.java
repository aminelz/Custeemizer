package com.lzi.Custeemizer.Common;

import com.lzi.Custeemizer.Authentication.EndUser;
import com.lzi.Custeemizer.Authentication.UserRepository;
import com.lzi.Custeemizer.ProfileManagement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository custrepo; //Asking spring to create instance of CustomerRepo to be able to use the given data manipulation methods

    @Autowired
    private UserRepository userrepo;
    @Autowired
    private ShippingRepository shippingrepo;
    @Autowired
    private PaymentRepository paymentrepo;

    @RequestMapping("/Customerss")
    public List<Customer> getCustomers(){
        return custrepo.findCustomers();
    }


//    @RequestMapping("/Test")
//    public List<Object[]> getAllCustomers(){
//        return custrepo.findAllCustomers();
//    }

    @RequestMapping("/CustomerUser/{id}")
    public Customer getCustomerInfo2(@PathVariable(value="id") long id){
        return custrepo.findCustomer(id);
    }

    @RequestMapping("/Customer/{id}")
    public Customer getCustomerInfo(@PathVariable(value="id") long id){
        return custrepo.findCustomerbyUserID(id);
    }

    @RequestMapping("/UserCustomer/{id}")
    public Object[] getUserofCustomer(@PathVariable(value="id") long id){
        return custrepo.findUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Register")
    public Map<String,Long> createCustomer(@RequestBody RegistrationForm registrationForm){
        EndUser newuser = new EndUser(registrationForm.getUser_email(), registrationForm.getUser_password(), registrationForm.getUser_firstname(), registrationForm.getUser_lastname(), Boolean.FALSE);
        userrepo.save(newuser);
        Customer newcustomer = new Customer(registrationForm.getCustomer_birthdate(), registrationForm.getCustomer_phonenumber(), newuser);
        custrepo.save(newcustomer);
        ShippingInfo newshipping = new ShippingInfo(registrationForm.getShipping_street(), registrationForm.getShipping_zipcode(), registrationForm.getShipping_city(),registrationForm.getShipping_country(), newcustomer);
        PaymentInfo newpayment = new PaymentInfo(registrationForm.getPayment_number(), registrationForm.getPayment_expiry(),registrationForm.getPayment_firstname(), registrationForm.getPayment_lastname(),registrationForm.getPayment_type(),registrationForm.getPayment_address(), newcustomer);
        shippingrepo.save(newshipping);
        paymentrepo.save(newpayment);
        newcustomer.setPayment(newpayment);
        newcustomer.setShipping(newshipping);
        custrepo.save(newcustomer);
        return Collections.singletonMap("customer_id", newuser.getUser_ID());
    }





}
