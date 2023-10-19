package com.Events.App.Organizers;


import java.util.Set;
import com.Events.App.Events.Events;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table
public class Organizers {
    @Id
    @SequenceGenerator(name="organizer_sequence",sequenceName = "organizer_sequence",allocationSize = 1)
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "organizer_sequence"
    )
    private Long Id;
    private String name;
    private int followers;
    private String email;
    // private String password;
    @ManyToMany
    @JoinTable(
        name="organizerEventMapping",
        joinColumns = @JoinColumn(name="organizer_id"),
        inverseJoinColumns = @JoinColumn(name="event_id")
    )
    private Set<Events> event;
    public Organizers(){
        
    }
    public Organizers(String email,int followers,String name){
        this.followers = 0;
        this.email = email;
        this.name = name;
    }
    public Set<Events> getEvent() {
        return event;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getFollowers() {
        return followers;
    }
    public Long getId() {
        return Id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setFollowers(int followers) {
        this.followers = followers;
    }
    public void setName(String name) {
        this.name = name;
    }
    // public void setEvent(Events event) {
    //     this.event = event;
    // }
    

    
}
