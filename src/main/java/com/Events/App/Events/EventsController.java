package com.Events.App.Events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Events.App.Organizers.Organizers;
@CrossOrigin
@RestController
@RequestMapping(path="/api/v1/event")
public class EventsController  
{
    private final EventService eventService;

    @Autowired
    public EventsController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping
    public List<Events> getAllEvents(){
        return this.eventService.getAllEvents();
    }
    @GetMapping("/{id}")
    public Events getEventById(@PathVariable("id") Long id){
        return this.eventService.findEventById(id);
    }
    @PostMapping
    public void postEvent(@RequestBody Events event,@RequestParam Long  organizerId){
        
        eventService.addEvents(event,organizerId);
    }

}