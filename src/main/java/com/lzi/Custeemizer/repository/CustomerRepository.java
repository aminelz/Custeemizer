package com.lzi.Custeemizer.repository;

import com.lzi.Custeemizer.model.UserCustomer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<UserCustomer,Long> {

//    @Query("SELECT new com.lzi.Custeemizer.model(e.first_name, e.last_name, e.email, c.address, c.phone_number, c.birth_date) "
//            + "FROM enduser e INNER JOIN d.customer c")
//    List<UserCustomer> fetchAllCustomers();


}
