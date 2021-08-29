package com.projecttwo.digitalkitchen.service;

import org.springframework.security.core.userdetails.User;
import com.projecttwo.digitalkitchen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AppUserDetails implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
      //  System.out.println(s);
        Optional<com.projecttwo.digitalkitchen.model.User> optional = userRepository.findById(s);
        com.projecttwo.digitalkitchen.model.User dbUser = optional.orElseThrow(() -> new UsernameNotFoundException(s));

//        String[] authorities=dbUser
//                .getAuthorities()
//                .stream()
//                .toArray(String[]::new);

        User user =new User(dbUser.getEmail(),dbUser.getPassword(), new ArrayList<>());

        return user;
    }
}
