package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.CarMedia;
import mg.rkmadagascar.gestionautomobile.repository.CarMediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarMediaService {

    private final CarMediaRepository repository;

    @Transactional(readOnly = true)
    public List<CarMedia> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public CarMedia findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "CarMedia introuvable : " + id));
    }

    @Transactional
    public CarMedia create(CarMedia entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public CarMedia update(String id, CarMedia entity) {
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
