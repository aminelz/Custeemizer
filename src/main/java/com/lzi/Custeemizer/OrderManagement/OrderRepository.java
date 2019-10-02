package com.lzi.Custeemizer.OrderManagement;

import com.lzi.Custeemizer.CartManagement.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order,Long> {


    @Query(value="SELECT * FROM torder ", nativeQuery = true)
    public List<Order> findAllOrders();

    @Query(value="SELECT *  FROM torder WHERE customer_id = ?1 ", nativeQuery = true)
    public List<Order> findOrderByCustomer(long id);


}
