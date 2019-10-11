package com.lzi.Custeemizer.Authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userrepo;

    @RequestMapping("/Admins")
    public List<EndUser> getAdmins(){
        return userrepo.findbyAdmin(true);
    }

    @RequestMapping("/Customers")
    public List<EndUser> getCustomers(){
        return userrepo.findbyAdmin(false);
    }

//    @RequestMapping("/User/{email}")
//    public String Emailexists(@PathVariable("email") String email){
//        return "Exists!";
//    }
//        if(userrepo.findemail(email) == 0){
//            return true;
//        }
//        else
//            return false;
//    }
}
