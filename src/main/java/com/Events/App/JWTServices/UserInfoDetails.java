package com.Events.App.JWTServices;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.Events.App.User.Users;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collection;

public class UserInfoDetails implements UserDetails{

    private String username;
    private String password;
    private List<GrantedAuthority> authority ;
    
    public UserInfoDetails(Users user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authority = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return this.authority;
    }
    @Override
    public String getUsername(){
        return this.username;
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override 
    public String getPassword() {
        return this.password;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }
}
