package com.lzi.Custeemizer.repository;

import com.lzi.Custeemizer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

//    @Query("SELECT new com.lzi.Custeemizer.model(e.first_name, e.last_name, e.email, c.address, c.phone_number, c.birth_date) "
//            + "FROM enduser e INNER JOIN d.customer c")
//    List<Customer> fetchAllCustomers();


}
