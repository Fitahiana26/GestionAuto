package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.Expence;
import mg.rkmadagascar.gestionautomobile.service.ExpenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expences")
@RequiredArgsConstructor
public class ExpenceController {

    private final ExpenceService service;

    @GetMapping
    public List<Expence> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Expence getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Expence> create(@RequestBody Expence entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public Expence update(@PathVariable String id, @RequestBody Expence entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
