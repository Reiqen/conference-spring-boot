package ru.neoflex.conferencespringboot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Без этой аннотации будет проблема сериализации при взятии отдельного объекта (ошибка 500)
public class Session {

    @Id // Определяет, что будет первичным ключом для записи
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Определяет, с каким ключом будет добавлена новая запись (IDENTITY позволяет базе подставить значение, если там есть sequence, он его использует)
    private Long session_id; // Если назвать поле так же, как оно называется в базе, то не надо добавлять аннотацию @Column
    private String session_name;
    private String session_description;
    private Integer session_length;

    @ManyToMany // Говорит о том, что должна быть join-таблица для соотношения многие ко многим
    @JoinTable (
            name = "session_speakers", // Имя таблицы, в которой есть соотношения
            joinColumns = @JoinColumn(name = "session_id"), // ID первой таблицы
            inverseJoinColumns = @JoinColumn(name = "speaker_id") // ID второй таблицы
        )
    private List<Speaker> speakers;

    public Session() {
        // Пустой конструктор, нужен для сериализации и десериализации в контроллерах
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Long getSession_id() {
        return session_id;
    }

    public void setSession_id(Long session_id) {
        this.session_id = session_id;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_description() {
        return session_description;
    }

    public void setSession_description(String session_description) {
        this.session_description = session_description;
    }

    public Integer getSession_length() {
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        this.session_length = session_length;
    }
}
