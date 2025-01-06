package com.example.formlogin.Security;

import com.example.formlogin.Repository.UserRepo;
import com.zapcom.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u=repo.findByName(username);
        System.out.println(u.getName());
        System.out.println(u.getPassword());
        System.out.println();
        return new UserPriniciple(repo.findByName(username));
    }
}
