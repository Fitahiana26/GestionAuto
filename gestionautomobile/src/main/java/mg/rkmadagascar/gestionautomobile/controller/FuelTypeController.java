package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.FuelType;
import mg.rkmadagascar.gestionautomobile.service.FuelTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuel-types")
@RequiredArgsConstructor
public class FuelTypeController {

    private final FuelTypeService service;

    @GetMapping
    public List<FuelType> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FuelType getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<FuelType> create(@RequestBody FuelType entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public FuelType update(@PathVariable String id, @RequestBody FuelType entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
