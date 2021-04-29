package ru.neoflex.conferencespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.conferencespringboot.models.Speaker;

public interface SpeakerRepository  extends JpaRepository<Speaker, Long> {
}
