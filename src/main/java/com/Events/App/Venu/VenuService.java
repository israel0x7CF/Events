package com.Events.App.Venu;
import java.util.List;
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
    public List<Venu> getAllVenus(){
        return this.venuRepository.findAll();
    }
    public Venu getVenuById(Long id){
        return this.venuRepository.findById(id).orElse(null);
    }
}
