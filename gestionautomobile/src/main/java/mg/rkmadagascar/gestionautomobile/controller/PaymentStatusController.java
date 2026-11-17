package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.PaymentStatus;
import mg.rkmadagascar.gestionautomobile.service.PaymentStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-status")
@RequiredArgsConstructor
public class PaymentStatusController {

    private final PaymentStatusService service;

    @GetMapping
    public List<PaymentStatus> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PaymentStatus getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<PaymentStatus> create(@RequestBody PaymentStatus entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public PaymentStatus update(@PathVariable String id, @RequestBody PaymentStatus entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
