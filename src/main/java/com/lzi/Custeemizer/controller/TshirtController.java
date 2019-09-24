package com.lzi.Custeemizer.controller;

import com.lzi.Custeemizer.model.Tshirt;
import com.lzi.Custeemizer.repository.TshirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TshirtController {

    @Autowired
    TshirtRepository tshirtrepo;

    @RequestMapping("/Products/{sex}")
    public List<Tshirt> getProductsofSex(@PathVariable(value="sex") String sex){
        return tshirtrepo.findbySex(sex);
    }

    @RequestMapping("/Products/{color}")
    public List<Tshirt> getProductsofColor(@PathVariable(value="color") String color){
        return tshirtrepo.findbyColor(color);
    }

    @RequestMapping("/Product/{higher_price}")
    public List<Tshirt> getProductsofPrice(@PathVariable(value="higher_price") double price){
        return tshirtrepo.findbyPrice(0,price);
    }



}
