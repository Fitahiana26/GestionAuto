package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Faq;
import mg.rkmadagascar.gestionautomobile.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqService {

    private final FaqRepository repository;

    @Transactional(readOnly = true)
    public List<Faq> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Faq findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Faq introuvable : " + id));
    }

    @Transactional
    public Faq create(Faq entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Faq update(String id, Faq entity) {
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
