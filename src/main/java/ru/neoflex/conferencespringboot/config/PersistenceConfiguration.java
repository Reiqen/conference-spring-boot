package ru.neoflex.conferencespringboot.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration // Аннотация показывает, что бины из этого класса используются для конфигурации проекта
public class PersistenceConfiguration {

    @Bean // Этот бин будет использован для конфигурации ресурса данных БД (добавление URL, логина и пароля)
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/conference");
        builder.username("postgres");
        builder.password("postgres");
        return builder.build();
    }
}
