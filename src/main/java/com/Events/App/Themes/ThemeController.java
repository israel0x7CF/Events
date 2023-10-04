package com.Events.App.Themes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/theme")
public class ThemeController {
    private ThemeService themeService;

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
    public void newTag(Theme theme)
    {
        // for admin purpose
        this.themeService.createTheme(theme);
    }
}
