package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Depense;
import mg.rkmadagascar.gestionautomobile.service.DepenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/depenses")
@RequiredArgsConstructor
public class DepenseController {

    private final DepenseService depenseService;

    @GetMapping
    public List<Depense> findAll() {
        return depenseService.findAll();
    }

    @GetMapping("/{id}")
    public Depense findById(@PathVariable String id) {
        return depenseService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Depense> creer(@RequestBody Depense depense) {
        return ResponseEntity.status(HttpStatus.CREATED).body(depenseService.creer(depense));
    }

    @PutMapping("/{id}")
    public Depense modifier(@PathVariable String id, @RequestBody Depense depense) {
        return depenseService.modifier(id, depense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        depenseService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
