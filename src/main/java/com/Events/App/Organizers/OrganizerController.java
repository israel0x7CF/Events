package com.Events.App.Organizers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Events.App.Organizers.Organizers;

@CrossOrigin
@RestController
@RequestMapping(path="/api/v1/organizer")
public class OrganizerController {
    private final OrganizerService organizerService;

    @Autowired
    public OrganizerController(OrganizerService organizerService){
        this.organizerService = organizerService;
    }
    @GetMapping
    public List<Organizers> getOrganizerList(){
        return organizerService.getOrganizers();
    }
    @PostMapping
    public void createOrganizer(@RequestBody Organizers organizer){
        this.organizerService.createOrganizer(organizer);

    }
    @GetMapping("/{id}")
    public Organizers getOrganizerById(@PathVariable("id") Long id){
        return this.organizerService.getOrgnizerById(id);
    }
    @PutMapping("/organizer/{id}")
    public void updateRating(@PathVariable("id") Long organizer_id,@RequestBody OrganizerDto oDto){
        Organizers organizer = this.organizerService.getOrgnizerById(organizer_id);

        if (organizer != null){
            if (!oDto.getEmail().isEmpty() ){
              
                organizer.setName(oDto.getName());
            }
            if (!oDto.getName().isEmpty()){
                organizer.setEmail(oDto.getEmail());
            }
        }

    }
    
}
