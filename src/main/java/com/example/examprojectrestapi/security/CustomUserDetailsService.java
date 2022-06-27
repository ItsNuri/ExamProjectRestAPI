package com.example.examprojectrestapi.security;

import com.example.examprojectrestapi.models.CustomUserDetails;
import com.example.examprojectrestapi.models.User;
import com.example.examprojectrestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = service.findByEmail(email);
        return CustomUserDetails.fromEntityToCustom(user);
    }
}
