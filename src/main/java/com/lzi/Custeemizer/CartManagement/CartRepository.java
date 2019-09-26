package com.lzi.Custeemizer.CartManagement;

import com.lzi.Custeemizer.CartManagement.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart,Long> {

    @Query(value="SELECT c.total FROM cart c " +
            "WHERE c.cart_ID = ?1  ", nativeQuery = true)
    public Cart findCartById(long cart_ID);
}
