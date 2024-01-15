package com.Events.App.Venu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path="/api/v1/venu")
public class VenuController {
    private VenuService venuService;


    public VenuController(VenuService venuService){
        this.venuService = venuService;
    }

    @PostMapping
    public void addVenu(@RequestBody Venu ven){
            this.venuService.addNewVenu(ven);
    }
   
    @GetMapping("/{id}")
    public Venu getVenuById(@PathVariable("id") long id){
        return this.venuService.getVenuById(id);
    }

}
