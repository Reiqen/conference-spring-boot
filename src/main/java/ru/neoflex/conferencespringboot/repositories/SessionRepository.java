package ru.neoflex.conferencespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.conferencespringboot.models.Session;

// Если расширить интерфейс, SessionRepository возьмёт все основные методы для репозитория, их не надо прописывать
public interface SessionRepository extends JpaRepository<Session, Long> { // JpaRepository - интерфейс, поэтому надо расширить его своим интерфейсом. Первый класс в дженерике - используемый класс, второй - тип первичного ключа
}
