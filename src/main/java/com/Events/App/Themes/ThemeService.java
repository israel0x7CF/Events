package com.Events.App.Themes;

import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ThemeService {
    private final ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository){
        this.themeRepository = themeRepository;
    }

    public List<Theme> getThemes(){
        return this.themeRepository.findAll();
    }

    public void createTheme(Theme theme){
        if(!this.themeRepository.findThemeByName(theme.getName()).isPresent()){
            this.themeRepository.save(theme);
        }
        else{
            throw new IllegalStateException("theme already exists");
        }

    }
}
