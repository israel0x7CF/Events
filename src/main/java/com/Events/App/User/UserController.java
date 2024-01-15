package com.Events.App.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Events.App.JWTServices.JwtService;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;



@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1/user")
public class UserController {


    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired 
    AuthenticationManager authenticationManager;
    Logger logger =LoggerFactory.getLogger(UserController.class);

    @PostMapping("/auth")
    public String getToken(@RequestBody AuthRequest data) {
       
        try{
            logger.info(data.getUsername());
            logger.info(data.getPassword());
            
            logger.info("Creting auth object");
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword()));
            logger.info("starting auth test");
            if(authentication.isAuthenticated()){
                logger.info("USer Authenticated Generating token");
                return jwtService.generateToken(data.getUsername());
            }

            else{
                throw new UsernameNotFoundException("invalid user request !"); 
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }

 
    }
    @PostMapping("/createprofile")
    public HashMap<String,Object> createUserProfile(@RequestBody Users entity) {
        HashMap<String,Object> repsonseBody= new HashMap<String,Object>();
       if(this.userInfoService.userValidator(entity)){
        repsonseBody.put("status", false);
        repsonseBody.put("message", "User Already Exists");
        
       }
       else{
           this.userInfoService.addUser(entity);
           repsonseBody.put("status", true);
           repsonseBody.put("message", "User created Successfully!");
        
       }
        return repsonseBody;
      
        

    }
    @GetMapping("/open")
    public String testEndpoint(@RequestParam(name = "email") String email) {
        
        return this.userInfoService.getUsersByEmail(email).getUsername();
    }

    
    
    

    
}
