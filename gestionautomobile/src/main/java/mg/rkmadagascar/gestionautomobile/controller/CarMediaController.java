package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.CarMedia;
import mg.rkmadagascar.gestionautomobile.service.CarMediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car-medias")
@RequiredArgsConstructor
public class CarMediaController {

    private final CarMediaService service;

    @GetMapping
    public List<CarMedia> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CarMedia getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<CarMedia> create(@RequestBody CarMedia entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public CarMedia update(@PathVariable String id, @RequestBody CarMedia entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
