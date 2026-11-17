package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.MovementType;
import mg.rkmadagascar.gestionautomobile.service.MovementTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movement-types")
@RequiredArgsConstructor
public class MovementTypeController {

    private final MovementTypeService service;

    @GetMapping
    public List<MovementType> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MovementType getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<MovementType> create(@RequestBody MovementType entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public MovementType update(@PathVariable String id, @RequestBody MovementType entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
