package com.Events.App.Organizers;

import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class OrganizerService 
{
    OrganizersRepository organizersRepository;
    

    public OrganizerService(OrganizersRepository oRepository){
        this.organizersRepository = oRepository;
    }
    // public UserDetails loadOrgan

    public List<Organizers> getOrganizers(){
        return this.organizersRepository.findAll();
    }
    

    public Long createOrganizer(Organizers organizer)
    {
        if(this.organizersRepository.findOrganizerByName(organizer.getName()).isPresent()){
            throw new IllegalStateException("this organizer already exsits");
        }
        else{
            // organizer.setPassword(passwordEncoder.encode(organizer.getPassoword()));
            organizersRepository.save(organizer);
            
        }
        return organizer.getId();
    }

    public Organizers getOrgnizerById(Long id){
        return this.organizersRepository.findById(id).orElse(null);
    }

}
