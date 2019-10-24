package com.lzi.Custeemizer.Common;

import com.lzi.Custeemizer.Authentication.EndUser;
import com.lzi.Custeemizer.Common.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

//    @Query("SELECT new com.lzi.Custeemizer.model(e.first_name, e.last_name, e.email, c.address, c.phone_number, c.birth_date) "
//            + "FROM enduser e INNER JOIN d.customer c")
//    List<Customer> fetchAllCustomers();

    //query to get all non-sensitive information of all customers
    @Query(value="SELECT c.customer_ID, u.first_name, u.last_name, u.email, c.birth_date, c.phone_number," +
            "s.street, s.city, s.zipcode, s.country," +
            "p.cc_type, p.cc_number FROM enduser u JOIN customer c ON u.user_ID = c.user_ID " +
            "JOIN shipping s ON  c.customer_ID = s.customer_ID " +
            "JOIN payment p ON c.customer_ID = p.customer_ID",nativeQuery = true)
    public List<Object[]> findAllCustomers();

//    //query to get all non-sensitive information of all customers
//    @Query(value="SELECT u.first_name, u.last_name, u.email, u.password, c.birth_date, c.phone_number," +
//            "s.street, s.city, s.zipcode, s.country," +
//            "p.cc_type, p.cc_number , p.cc_address FROM enduser u JOIN customer c ON u.user_ID = c.user_ID " +
//            "JOIN shipping s ON  c.customer_ID = s.customer_ID " +
//            "JOIN payment p ON c.customer_ID = p.customer_ID " +
//            "WHERE c.customer_ID = ?1",nativeQuery = true)
//    public List<Object[]> findCustomerById(long id);

    @Query(value="SELECT * from customer" +
            " WHERE customer_id  = ?1 ", nativeQuery = true)
    public Customer findCustomer(long id);

    @Query(value="SELECT * from customer", nativeQuery = true)
    public List<Customer> findCustomers();


    @Query(value="SELECT u.* FROM enduser u " +
            "JOIN customer c ON u.user_ID = c.user_ID WHERE c.customer_ID = ?1 ", nativeQuery = true)
    public Object[] findUser(long id);

}
