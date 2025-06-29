package com.security.security.service;

import com.security.security.model.User;
import com.security.security.model.UserPricipal;
import com.security.security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
     private final UserRepository userRepository;
     public  UserDetailsServiceImpl(UserRepository userRepository){
         this.userRepository=userRepository;
     }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user=userRepository.findByEmail(email);

        if (email==null){
            throw new UsernameNotFoundException( "user not found"+email);
        }
        return   new UserPricipal(user);
    }
}
