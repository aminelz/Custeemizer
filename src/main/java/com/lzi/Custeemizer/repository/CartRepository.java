package com.lzi.Custeemizer.repository;

import com.lzi.Custeemizer.model.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart,Long> {

    @Query(value="SELECT c.total FROM Cart c WHERE c.cart_id = ?1 ",nativeQuery = true)
    public Cart findTotalByCart_ID(long cart_ID);
}
