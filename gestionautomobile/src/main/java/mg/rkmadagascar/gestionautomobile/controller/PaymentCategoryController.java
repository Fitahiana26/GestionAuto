package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.PaymentCategory;
import mg.rkmadagascar.gestionautomobile.service.PaymentCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-categories")
@RequiredArgsConstructor
public class PaymentCategoryController {

    private final PaymentCategoryService service;

    @GetMapping
    public List<PaymentCategory> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PaymentCategory getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<PaymentCategory> create(@RequestBody PaymentCategory entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public PaymentCategory update(@PathVariable String id, @RequestBody PaymentCategory entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
