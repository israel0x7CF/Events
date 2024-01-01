package com.Events.App.User;
import org.springframework.data.annotation.Transient;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
     Long Id;
    private String username;
    private String email;
    private String password ;
    private String  role;

    
    

}
