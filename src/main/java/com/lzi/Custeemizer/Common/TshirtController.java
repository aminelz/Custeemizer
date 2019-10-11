package com.lzi.Custeemizer.Common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class TshirtController {

    @Autowired
    TshirtRepository tshirtrepo;

    //Sex Category
    @RequestMapping("/Product/Tshirt/Sex/{sex}")
    public List<Tshirt> getTshirtsofSex(@PathVariable(value="sex") String sex){
        return tshirtrepo.findbySex(sex);
    }

    //Color Category
    @RequestMapping("/Product/Tshirt/Color/{color}")
    public List<Tshirt> getTshirtofColor(@PathVariable(value="color") String color){
        return tshirtrepo.findbyColor(color);
    }

    //Price Category
    @RequestMapping("/Product/Tshirt/Price/{higher_price}")
    public List<Tshirt> getTshirtofPrice(@PathVariable(value="higher_price") double price){
        return tshirtrepo.findbyPrice(0,price);
    }

    //Get Specific Tshirt info
    @RequestMapping("Product/Tshirt/{id}")
    public Optional<Tshirt> getTshirtbyID(@PathVariable(value="id") long id){
        return tshirtrepo.findById(id);
    }

    //Get All Tshirts
    @RequestMapping("/Product/Tshirt")
    public Iterable<Tshirt> getAllTshirts(){return tshirtrepo.findAll();}

}
