package com.lzi.Custeemizer.service;

import com.lzi.Custeemizer.model.EndUser;
import com.lzi.Custeemizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userrepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        EndUser currentUser = userrepo.findByEmail(email);
        UserDetails user = new org.springframework.security.core
                .userdetails.User(email, currentUser.getPassword()
                , true, true, true, true,
                AuthorityUtils.createAuthorityList(currentUser.getAdmin().toString()));
        return user;
    }

}
