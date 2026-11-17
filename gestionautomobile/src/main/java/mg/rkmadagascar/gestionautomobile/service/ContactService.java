package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Contact;
import mg.rkmadagascar.gestionautomobile.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repository;

    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Contact findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact introuvable : " + id));
    }

    @Transactional
    public Contact create(Contact entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Contact update(String id, Contact entity) {
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
