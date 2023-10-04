package com.Events.App.Events;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import com.Events.App.Organizers.OrganizerService;
import com.Events.App.Events.EventRepository;
import com.Events.App.Organizers.Organizers;
import com.Events.App.Organizers.OrganizersRepository;



@Service
// Add more logic and features
public class EventService {
    private final EventRepository eventRepository;
    private final OrganizerService organizerService;

    
    
    public EventService(EventRepository eventRepository,OrganizerService organizerService){
        this.eventRepository = eventRepository;
        this.organizerService = organizerService;
    }
    public List<Events> getAllEvents(){
        return eventRepository.findAll();
    }
    public Events findEventById(Long id)
    {
        return this.eventRepository.findById(id).orElse(null);
    }
    public void addEvents(Events event,Long organizerid)
    {
        Optional<Events> e = eventRepository.findEventByName(event.getName());
        // Long id = organizerService.createOrganizer(organizer);
        Set<Organizers> organizers = new HashSet<>();
        // insert a null check
        organizers.add(this.organizerService.getOrgnizerById(organizerid));
        

        if(e.isPresent()){
            throw new IllegalStateException("Email already Exists");
        }
        // modify this once relations are added
        
        event.setOrganizers(organizers);
        eventRepository.save(event);
    
    }
 
}
