package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Expence;
import mg.rkmadagascar.gestionautomobile.repository.ExpenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenceService {

    private final ExpenceRepository repository;

    @Transactional(readOnly = true)
    public List<Expence> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Expence findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Expence introuvable : " + id));
    }

    @Transactional
    public Expence create(Expence entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Expence update(String id, Expence entity) {
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
