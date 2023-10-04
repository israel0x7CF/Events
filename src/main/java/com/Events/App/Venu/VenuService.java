package com.Events.App.Venu;

import org.springframework.stereotype.Service;

@Service
public class VenuService {
    private final VenuRepository venuRepository;

    public VenuService(VenuRepository venuRepository){
        this.venuRepository = venuRepository;
    }

    public void addNewVenu(Venu venu){
        this.venuRepository.save(venu);
    }
}
