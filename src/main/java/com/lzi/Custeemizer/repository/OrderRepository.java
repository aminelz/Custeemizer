package com.lzi.Custeemizer.repository;

import com.lzi.Custeemizer.model.Cart;
import com.lzi.Custeemizer.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {


}
