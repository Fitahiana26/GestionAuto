package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Sale;
import mg.rkmadagascar.gestionautomobile.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository repository;

    @Transactional(readOnly = true)
    public List<Sale> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Sale findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Sale introuvable : " + id));
    }

    @Transactional
    public Sale create(Sale entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Sale update(String id, Sale entity) {
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
