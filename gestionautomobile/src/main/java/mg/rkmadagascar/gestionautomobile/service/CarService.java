package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Car;
import mg.rkmadagascar.gestionautomobile.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;

    @Transactional(readOnly = true)
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Car findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Car introuvable : " + id));
    }

    @Transactional
    public Car create(Car entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Car update(String id, Car entity) {
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
