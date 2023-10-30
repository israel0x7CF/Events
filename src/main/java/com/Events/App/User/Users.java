package com.Events.App.User;
import org.springframework.data.annotation.Transient;
import jakarta.persistence.*;

@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    private Long Id;
    private String Username;
    private String Email;
    
    public Users(){

    }
    public Users(String Email,String Username){
        this.Email = Email;
        this.Username = Username;
    }

    public String geUsername(){
        return this.Username;
    }
    public String getEmail(){
        return this.Email;
    }
    public void setEmail(String Email)
    {
        this.Email = Email;
    }
    public void setUsername(String Username)
    {
        this.Username = Username;
    }
}
