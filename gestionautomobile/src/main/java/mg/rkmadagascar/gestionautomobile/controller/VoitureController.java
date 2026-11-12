package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Voiture;
import mg.rkmadagascar.gestionautomobile.service.VoitureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voitures")
@RequiredArgsConstructor
public class VoitureController {

    private final VoitureService voitureService;

    @GetMapping
    public List<Voiture> findAll() {
        return voitureService.findAll();
    }

    @GetMapping("/{id}")
    public Voiture findById(@PathVariable String id) {
        return voitureService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Voiture> creer(@RequestBody Voiture voiture) {
        return ResponseEntity.status(HttpStatus.CREATED).body(voitureService.creer(voiture));
    }

    @PutMapping("/{id}")
    public Voiture modifier(@PathVariable String id, @RequestBody Voiture voiture) {
        return voitureService.modifier(id, voiture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        voitureService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
