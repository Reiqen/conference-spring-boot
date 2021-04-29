package ru.neoflex.conferencespringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Value("${app.version}") // Вернет значение из файла properties
    private String version;

    @GetMapping
    public String getVersion() {
        return version;
    }
}
