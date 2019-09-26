package com.lzi.Custeemizer.Common;

import com.lzi.Custeemizer.Common.Tshirt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TshirtRepository extends CrudRepository<Tshirt,Long> {

    @Query(value= "SELECT * FROM tshirt WHERE sex = ?1", nativeQuery=true) //sql query
    public List<Tshirt> findbySex(String sex);

    @Query(value= "SELECT * FROM tshirt WHERE color = ?1", nativeQuery=true) //sql query
    public List<Tshirt> findbyColor(String color);

    @Query(value= "SELECT * FROM tshirt WHERE ?1< price < ?2", nativeQuery=true) //sql query
    public List<Tshirt> findbyPrice(double lower_price, double higher_price);


}
