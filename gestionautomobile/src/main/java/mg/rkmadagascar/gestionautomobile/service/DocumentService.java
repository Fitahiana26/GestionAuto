package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Document;
import mg.rkmadagascar.gestionautomobile.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository repository;

    @Transactional(readOnly = true)
    public List<Document> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Document findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Document introuvable : " + id));
    }

    @Transactional
    public Document create(Document entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Document update(String id, Document entity) {
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
