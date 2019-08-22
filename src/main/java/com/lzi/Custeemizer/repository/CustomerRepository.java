package com.lzi.Custeemizer.repository;

import com.lzi.Custeemizer.model.UserCustomer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<UserCustomer,Long> {


}
