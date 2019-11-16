package com.lzi.Custeemizer.Authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

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

    @RequestMapping(method = RequestMethod.POST, value = "/Login")
    public Map<String,String> login(@RequestBody AccountCredentials accountCredentials){
        int count = userrepo.findemail(accountCredentials.getEmail());
        final Map<String, String> returnmap = new HashMap<String,String>();
        if (count == 1){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            EndUser user = userrepo.getlogin(accountCredentials.getEmail());
            System.out.println(user.getPassword());
            boolean match = passwordEncoder.matches(accountCredentials.getPassword(), user.getPassword());
            System.out.println(match);
            if (match == true){
                if(user.getAdmin()){
                    returnmap.put("login_status", "Admin");
                }else{
                    returnmap.put("login_status", "Customer");
                }
                returnmap.put("id", String.valueOf(user.getUser_ID()));
            } else if(match == false){
                returnmap.put("login_status", "wrong");
                returnmap.put("id", null);
            }


        }
        else if (count == 0){
            returnmap.put("login_status", null);
            returnmap.put("id", null);
        }
        return returnmap;
    }

}
