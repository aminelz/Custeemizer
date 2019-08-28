package com.lzi.Custeemizer.repository;


import com.lzi.Custeemizer.model.EndUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <EndUser,Long> {


}
