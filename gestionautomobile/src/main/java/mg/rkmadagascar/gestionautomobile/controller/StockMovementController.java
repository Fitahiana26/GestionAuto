package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.StockMovement;
import mg.rkmadagascar.gestionautomobile.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-movements")
@RequiredArgsConstructor
public class StockMovementController {

    private final StockMovementService service;

    @GetMapping
    public List<StockMovement> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StockMovement getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<StockMovement> create(@RequestBody StockMovement entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public StockMovement update(@PathVariable String id, @RequestBody StockMovement entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
