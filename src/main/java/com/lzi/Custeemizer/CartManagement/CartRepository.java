package com.lzi.Custeemizer.CartManagement;

import com.lzi.Custeemizer.CartManagement.Cart;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart,Long> {

    @Query(value="SELECT * from cart where cart_id = ?1", nativeQuery = true)
    public Cart findcartByID(long cart_ID);

    @Query(value="SELECT cart_ID FROM Cart ORDER BY cart_ID DESC LIMIT 1", nativeQuery=true)
    public long findIDoflastCart();

    @Modifying
    @Query(value="UPDATE cart SET total = ?2 WHERE cart_ID = ?1", nativeQuery = true)
    public void changeTotalPrice(long id, double price);

//    @Modifying
//    @Query("UPDATE cart c SET c.total = :price WHERE c.cart_id = :id")
//    int setTotalPrice(@Param("price") double price, @Param("id") long id);





}
