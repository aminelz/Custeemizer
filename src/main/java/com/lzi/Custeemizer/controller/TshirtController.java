package com.lzi.Custeemizer.controller;

import com.lzi.Custeemizer.model.Tshirt;
import com.lzi.Custeemizer.repository.TshirtRepository;
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

    @RequestMapping("/Product/Tshirt/Sex/{sex}")
    public List<Tshirt> getTshirtsofSex(@PathVariable(value="sex") String sex){
        return tshirtrepo.findbySex(sex);
    }

    @RequestMapping("/Product/Tshirt/Color/{color}")
    public List<Tshirt> getTshirtofColor(@PathVariable(value="color") String color){
        return tshirtrepo.findbyColor(color);
    }

    @RequestMapping("/Product/Tshirt/Price/{higher_price}")
    public List<Tshirt> getTshirtofPrice(@PathVariable(value="higher_price") double price){
        return tshirtrepo.findbyPrice(0,price);
    }

    @RequestMapping("Product/Tshirt/{id}")
    public Optional<Tshirt> getTshirtbyID(@PathVariable(value="id") long id){
        return tshirtrepo.findById(id);
    }

    @RequestMapping("/Product/Tshirt")
    public Iterable<Tshirt> getAllTshirts(){return tshirtrepo.findAll();}

}
