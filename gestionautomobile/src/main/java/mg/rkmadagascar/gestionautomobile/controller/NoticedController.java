package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.Noticed;
import mg.rkmadagascar.gestionautomobile.service.NoticedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noticeds")
@RequiredArgsConstructor
public class NoticedController {

    private final NoticedService service;

    @GetMapping
    public List<Noticed> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Noticed getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Noticed> create(@RequestBody Noticed entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public Noticed update(@PathVariable String id, @RequestBody Noticed entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
