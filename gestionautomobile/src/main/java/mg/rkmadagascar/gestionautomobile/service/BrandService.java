package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Brand;
import mg.rkmadagascar.gestionautomobile.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository repository;

    @Transactional(readOnly = true)
    public List<Brand> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Brand findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Brand introuvable : " + id));
    }

    @Transactional
    public Brand create(Brand entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Brand update(String id, Brand entity) {
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
