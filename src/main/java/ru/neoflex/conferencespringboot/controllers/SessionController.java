package ru.neoflex.conferencespringboot.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.conferencespringboot.models.Session;
import ru.neoflex.conferencespringboot.repositories.SessionRepository;

import java.util.List;

@RestController // Аннотация говорит о том, что это контроллер. Rest избавляет от необходимости во всем методах указывать @ResponseBody - указатель на то, что возвращаемый объект должен быть сериализован в тело ответа
@RequestMapping("api/v1/sessions") // Аннотация указывает url для маппинга. Каждый следующий метод дополняется аннотациями GetMapping или PostMapping
public class SessionController {

    @Autowired // Автоматический поиск и создание sessionRepository
    private SessionRepository sessionRepository;

    @GetMapping // Аннотация говорит, что для get-запроса без дополнительных данных в url отработает этот метод и промаппит данные в JSON
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping("{id}") // Аннотация говорит, что при указании id в url вернётся конкретный Session в виде JSON
    public Session get(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    /* @GetMapping("{string}")
    public String getString(@PathVariable String string) {
        return string;
    } если добавить после слеша строку в адресной строке, то она промаппится в ответ */

    @PostMapping // Аннотация для POST-запроса
    // @ResponseStatus(HttpStatus.CREATED) Вернёт нужный статус для ответа
    public Session create(@RequestBody final Session session) { // RequestBody маппит JSON с запроса в Java-объект
        return sessionRepository.saveAndFlush(session); // Flush коммитит сохранённый объект в базу
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE) // В Spring есть только GetMapping и PostMapping, но нет DeleteMapping, поэтому приходится использовать универсальный RequestMapping и указывать метод
    public void delete(@PathVariable Long id) { // RequestBody маппит JSON с запроса в Java-объект
        sessionRepository.deleteById(id); // Flush коммитит сохранённый объект в базу
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) { // RequestBody маппит JSON с запроса в Java-объект
        Session existingSession = sessionRepository.getOne(id); // Сначала берём существующую запись
        BeanUtils.copyProperties(session, existingSession, "session_id"); // Копируем всё из сессии с запроса в существующую сессию, исключая ID
        return sessionRepository.saveAndFlush(existingSession); // Сохраняем и коммитим обновлённую сессию
    }
}
