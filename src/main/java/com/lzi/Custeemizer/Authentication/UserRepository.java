package com.lzi.Custeemizer.Authentication;


import com.lzi.Custeemizer.Authentication.EndUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//<EndUser,Long> Defines that the CRUD repo is for the EndUser Class and that the ID field is of type Long
public interface UserRepository extends CrudRepository <EndUser,Long> {

    //Finding Admin/Normal Customers One query is is native sql and other is in jpql
//    @Query("select x from EndUser x where x.admin = ?1 ") //jpql query
//    List<EndUser> findAdmin(Boolean admin);
    @Query(value= "SELECT * FROM enduser WHERE admin = ?1", nativeQuery=true) //sql query
    public List<EndUser> findbyAdmin(Boolean admin);

    // /!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\
    //  /!\ /!\/!\ /!\ /!\ /!\ NEED TO USE NAMED QUERIES /!\ /!\ /!\ /!\/!\ /!\/!\
    // /!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\/!\ /!\

    //query to get all non-sensitive information of all customers
    @Query(value="SELECT c.customer_ID, u.first_name, u.last_name, u.email, c.birth_date, c.phone_number," +
            "s.street, s.city, s.zipcode, s.country," +
            "p.cc_type, p.cc_number FROM enduser u JOIN customer c ON u.user_ID = c.user_ID " +
            "JOIN shipping s ON  c.customer_ID = s.customer_ID " +
            "JOIN payment p ON c.customer_ID = p.customer_ID",nativeQuery = true)
    public List<Object[]> findAllCustomers();

    //query to get all non-sensitive information of all customers
    @Query(value="SELECT u.first_name, u.last_name, u.email, c.birth_date, c.phone_number," +
            "s.street, s.city, s.zipcode, s.country," +
            "p.cc_type, p.cc_number FROM enduser u JOIN customer c ON u.user_ID = c.user_ID " +
            "JOIN shipping s ON  c.customer_ID = s.customer_ID " +
            "JOIN payment p ON c.customer_ID = p.customer_ID " +
            "WHERE c.customer_ID = ?1",nativeQuery = true)
    public List<Object[]> findCustomerById(long id);



    //query that looks for the user matching the customer_ID provided in the url and displays their important joined table fields
    @Query(value="SELECT u.last_name, u.first_name, u.email, c.birth_date, c.phone_number FROM customer c " +
            "JOIN enduser u ON u.user_ID = c.user_ID WHERE c.customer_ID = ?1  ", nativeQuery = true)
    public List<Object[]> findUserByCustomer(long customer_ID);

    EndUser findByEmail(String email);




}
