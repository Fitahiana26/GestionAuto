package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.MouvementReservation;
import mg.rkmadagascar.gestionautomobile.service.MouvementReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mouvement-reservations")
@RequiredArgsConstructor
public class MouvementReservationController {

    private final MouvementReservationService service;

    @GetMapping
    public List<MouvementReservation> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MouvementReservation getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<MouvementReservation> create(@RequestBody MouvementReservation entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public MouvementReservation update(@PathVariable String id, @RequestBody MouvementReservation entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
