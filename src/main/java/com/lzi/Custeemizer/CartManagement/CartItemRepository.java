package com.lzi.Custeemizer.CartManagement;

import com.lzi.Custeemizer.CartManagement.CartItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem,Long> {

    @Query(value="SELECT t.*, ci.quantity, ct.total FROM cartitem ci " +
            "JOIN tshirt t ON t.tshirt_id = ci.tshirt_id " +
            "JOIN cart ct ON ct.cart_id = ci.cart_id " +
            "WHERE ci.cart_id =?1",nativeQuery = true)
    public List<CartItem> getItemsByCartId(long id);

    @Query(value="SELECT c.* FROM cartitem c "+
            "WHERE c.cart_id =?1",nativeQuery = true)
    public List<CartItem> getAllItems(long id);

    @Query(value="SELECT Count(*) FROM cartitem c WHERE c.cart_ID = ?1", nativeQuery = true)
    public int findCartCount(long id);

    @Query(value="SELECT i.* FROM cartitem i WHERE i.item_id =?1", nativeQuery = true)
    public CartItem findItem(long id);

}
