package com.lzi.Custeemizer.repository;

import com.lzi.Custeemizer.model.Cart;
import com.lzi.Custeemizer.model.ShippingInfo;
import org.springframework.data.repository.CrudRepository;

public interface ShippingRepository extends CrudRepository<ShippingInfo,Long> {


}
