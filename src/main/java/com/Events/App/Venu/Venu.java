package com.Events.App.Venu;

import org.hibernate.annotations.Type;

import com.Events.App.Events.Events;
import java.util.Set;
import jakarta.persistence.*;
@Entity
@Table
public class Venu {
    @Id
    @SequenceGenerator(name="venu_sequence",sequenceName = "venu_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="venu_sequence")
    
    private long id;
    private String name;

    private String location;

    @ManyToMany(mappedBy = "venus")
    Set<Events> events;
    

    public Venu(){

    }
    public Venu(String name,String location){
        this.name = name;
        this.location = location;

    }

    public String getLocation() {
        return this.location;
    }
    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setName(String name) {
        this.name = name;
    }
}
