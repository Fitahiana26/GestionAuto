package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.FuelType;
import mg.rkmadagascar.gestionautomobile.repository.FuelTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelTypeService {

    private final FuelTypeRepository repository;

    @Transactional(readOnly = true)
    public List<FuelType> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public FuelType findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "FuelType introuvable : " + id));
    }

    @Transactional
    public FuelType create(FuelType entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public FuelType update(String id, FuelType entity) {
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
