package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Status;
import mg.rkmadagascar.gestionautomobile.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository repository;

    @Transactional(readOnly = true)
    public List<Status> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Status findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Status introuvable : " + id));
    }

    @Transactional
    public Status create(Status entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Status update(String id, Status entity) {
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
