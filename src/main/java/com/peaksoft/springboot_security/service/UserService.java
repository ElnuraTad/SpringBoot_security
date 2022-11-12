package com.peaksoft.springboot_security.service;

import com.peaksoft.springboot_security.entity.MyUser;
import com.peaksoft.springboot_security.entity.User;
import com.peaksoft.springboot_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUser(user);
    }
}
