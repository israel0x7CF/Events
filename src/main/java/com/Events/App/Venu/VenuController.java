package com.Events.App.Venu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/venu")
public class VenuController {
    private VenuService venuService;

    @Autowired
    public VenuController(VenuService venuService){
        this.venuService = venuService;
    }

    @PostMapping
    public void addVenu(@RequestBody Venu ven){
            this.venuService.addNewVenu(ven);
    }
}
