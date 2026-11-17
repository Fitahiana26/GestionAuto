package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.Faq;
import mg.rkmadagascar.gestionautomobile.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faqs")
@RequiredArgsConstructor
public class FaqController {

    private final FaqService service;

    @GetMapping
    public List<Faq> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Faq getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Faq> create(@RequestBody Faq entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public Faq update(@PathVariable String id, @RequestBody Faq entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
