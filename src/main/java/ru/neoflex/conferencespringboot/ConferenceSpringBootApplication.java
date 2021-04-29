package ru.neoflex.conferencespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("ru.neoflex.conferencespringboot")
public class ConferenceSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceSpringBootApplication.class, args);
    }

}
