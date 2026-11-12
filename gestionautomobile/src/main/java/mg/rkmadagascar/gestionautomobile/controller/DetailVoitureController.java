package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.DetailVoiture;
import mg.rkmadagascar.gestionautomobile.service.DetailVoitureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/details-voiture")
@RequiredArgsConstructor
public class DetailVoitureController {

    private final DetailVoitureService detailVoitureService;

    @GetMapping
    public List<DetailVoiture> findAll() {
        return detailVoitureService.findAll();
    }

    @GetMapping("/{id}")
    public DetailVoiture findById(@PathVariable String id) {
        return detailVoitureService.findById(id);
    }

    @PostMapping
    public ResponseEntity<DetailVoiture> creer(@RequestBody DetailVoiture detailVoiture) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detailVoitureService.creer(detailVoiture));
    }

    @PutMapping("/{id}")
    public DetailVoiture modifier(@PathVariable String id, @RequestBody DetailVoiture detailVoiture) {
        return detailVoitureService.modifier(id, detailVoiture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        detailVoitureService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
