package com.lzi.Custeemizer.OrderManagement;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order,Long> {


    @Query(value="SELECT order_id FROM torder", nativeQuery = true)
    public List<Order> findAllOrders();



}
