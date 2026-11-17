package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.StockMovement;
import mg.rkmadagascar.gestionautomobile.repository.StockMovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockMovementService {

    private final StockMovementRepository repository;

    @Transactional(readOnly = true)
    public List<StockMovement> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public StockMovement findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "StockMovement introuvable : " + id));
    }

    @Transactional
    public StockMovement create(StockMovement entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public StockMovement update(String id, StockMovement entity) {
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
