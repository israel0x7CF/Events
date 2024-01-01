package com.Events.App.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import java.util.List;
import com.Events.App.JWTServices.UserInfoDetails;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    Logger logger = LoggerFactory.getLogger(UserInfoService.class);
    public UserDetails loadUserByUsername(String username){
        Optional<Users> userInfo = userRepository.findByUsername(username);
       logger.info(userInfo.toString());

        return userInfo.map(UserInfoDetails::new).orElseThrow(()-> new UsernameNotFoundException("UserName not found"));
    }
    public String addUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Created";
    }
    public List<Users> getAllUsers(){
        return this.userRepository.findAll();
    }
    public Users getUsersByEmail(String email){
        logger.info(email);
        return this.userRepository.findByEmail(email).orElse(null);
    }
    // returns true if user exists
    public boolean userValidator(Users user)
    {
        if(this.userRepository.findByEmail(user.getEmail()) != null || this.userRepository.findByUsername(user.getUsername()) != null){
            return true;
        }
        else{
            return false;
        }
    }
    
}
