package com.Events.App.Themes;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path="/api/v1/themes")
public class ThemeController {
    private ThemeService themeService;
    Logger logger = LoggerFactory.getLogger(ThemeController.class);
    @Autowired
    public ThemeController(ThemeService themeService)
    {
        this.themeService = themeService;
    }  
    @GetMapping
    public List<Theme> getTags(){
        return this.themeService.getThemes();
    }
    @PostMapping
    public void newTag(@RequestBody Theme theme)
    {
        // for admin purpose
        this.themeService.createTheme(theme);
       
    }
}
