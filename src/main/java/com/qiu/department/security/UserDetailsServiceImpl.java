package com.qiu.department.security;

import com.qiu.department.entity.User;
import com.qiu.department.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userService.queryByUsername(username);
        Collection<GrantedAuthority> authorities = getAuthority(user);


        return new org.springframework.security.core.userdetails.User(username,user.getPassword(), authorities);
    }

    private Collection<GrantedAuthority> getAuthority(User user){
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String[] auths =  user.getAuthority().split(",");
        for(String auth : auths){
            authorities.add(new SimpleGrantedAuthority(auth));
        }
        return authorities;
    }

















}
