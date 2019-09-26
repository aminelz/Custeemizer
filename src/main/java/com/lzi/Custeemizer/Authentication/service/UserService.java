package com.lzi.Custeemizer.Authentication.service;

import com.lzi.Custeemizer.Authentication.EndUser;
import com.lzi.Custeemizer.Authentication.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userrepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        EndUser currentUser = userrepo.findByEmail(email);
        UserDetails user = new org.springframework.security.core
                .userdetails.User(email, userrepo.findByEmail(email).getPassword()
                , true, true, true, true,
                AuthorityUtils.createAuthorityList(currentUser.getAdmin().toString()));
        return user;
    }

}
