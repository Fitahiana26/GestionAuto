package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Message;
import mg.rkmadagascar.gestionautomobile.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository repository;

    @Transactional(readOnly = true)
    public List<Message> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Message> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Transactional(readOnly = true)
    public Message findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Message introuvable : " + id));
    }

    @Transactional
    public Message create(Message entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Message update(String id, Message entity) {
        findById(id);
        entity.setId(id);
        return repository.save(entity);
    }

    @Transactional
    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}