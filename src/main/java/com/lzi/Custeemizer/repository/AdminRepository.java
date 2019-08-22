package com.lzi.Custeemizer.repository;

import com.lzi.Custeemizer.model.UserAdmin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<UserAdmin,Long> {


}