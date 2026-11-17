package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Noticed;
import mg.rkmadagascar.gestionautomobile.repository.NoticedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticedService {

    private final NoticedRepository repository;

    @Transactional(readOnly = true)
    public List<Noticed> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Noticed findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Noticed introuvable : " + id));
    }

    @Transactional
    public Noticed create(Noticed entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Noticed update(String id, Noticed entity) {
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
