package com.Events.App.Themes;
import org.springframework.data.annotation.Transient;

import com.Events.App.Events.Events;

import jakarta.persistence.*;
@Entity
@Table
public class Theme {
    @Id
    @SequenceGenerator(
        name="theme_sequence",sequenceName = "theme_sequence",allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "theme_sequence"
    )
    private Long Id;
    private String name;
    private String Discrpiton;
    @ManyToOne
    @JoinColumn(name = "EventId")
    Events events;

    public Theme(){


    }
    public Theme(String name,String Discrpiton)
    {
        this.name = name;
        this.Discrpiton = Discrpiton; // use the description to be displayed on hover
    }
    public String getDiscrpiton() {
        return Discrpiton;
    }
    public Events getEvents() {
        return events;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDiscrpiton(String discrpiton) {
        this.Discrpiton = discrpiton;
    }
    public void setEvents(Events events) {
        this.events = events;
    }
}
