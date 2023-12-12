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

    public List<Organizers> getOrganizers(){
        return this.organizersRepository.findAll();
    }
    

    public Long createOrganizer(Organizers org)
    {
        if(this.organizersRepository.findOrganizerByName(org.getName()).isPresent()){
            throw new IllegalStateException("this organizer already exsits");
        }
        else{
            organizersRepository.save(org);
            
        }
        return org.getId();
    }

    public Organizers getOrgnizerById(Long id){
        return this.organizersRepository.findById(id).orElse(null);
    }

}
