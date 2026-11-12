package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Marque;
import mg.rkmadagascar.gestionautomobile.service.MarqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marques")
@RequiredArgsConstructor
public class MarqueController {

    private final MarqueService marqueService;

    @GetMapping
    public List<Marque> findAll() {
        return marqueService.findAll();
    }

    @GetMapping("/{id}")
    public Marque findById(@PathVariable String id) {
        return marqueService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Marque> creer(@RequestBody Marque marque) {
        return ResponseEntity.status(HttpStatus.CREATED).body(marqueService.creer(marque));
    }

    @PutMapping("/{id}")
    public Marque modifier(@PathVariable String id, @RequestBody Marque marque) {
        return marqueService.modifier(id, marque);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        marqueService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
