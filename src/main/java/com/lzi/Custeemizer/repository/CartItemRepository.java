package com.lzi.Custeemizer.repository;

import com.lzi.Custeemizer.model.Cart;
import com.lzi.Custeemizer.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem,Long> {


}
