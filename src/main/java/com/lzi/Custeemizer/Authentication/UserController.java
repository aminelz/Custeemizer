package com.lzi.Custeemizer.Authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @RequestMapping(value = "/User/{email:.+}/email")
    public Map<String,Boolean> getUser(@PathVariable(value="email") String email){
        int count = userrepo.findemail(email);
        if ( count == 1){

            return Collections.singletonMap("response", true);
        }
        else
        return Collections.singletonMap("response", false);
    }



}
