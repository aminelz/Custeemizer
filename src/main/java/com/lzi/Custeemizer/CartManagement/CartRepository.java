package com.lzi.Custeemizer.CartManagement;

import com.lzi.Custeemizer.CartManagement.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart,Long> {

    @Query(value="SELECT * from cart where cart_id = ?1", nativeQuery = true)
    public Cart findTotalofCartById(long cart_ID);

}
