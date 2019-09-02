package com.lzi.Custeemizer.repository;

import com.lzi.Custeemizer.model.Cart;
import com.lzi.Custeemizer.model.PaymentInfo;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<PaymentInfo,Long> {


}
