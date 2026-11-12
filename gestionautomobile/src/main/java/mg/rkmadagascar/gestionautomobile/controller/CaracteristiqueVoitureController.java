package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.CaracteristiqueVoiture;
import mg.rkmadagascar.gestionautomobile.service.CaracteristiqueVoitureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/caracteristiques-voiture")
@RequiredArgsConstructor
public class CaracteristiqueVoitureController {

    private final CaracteristiqueVoitureService caracteristiqueVoitureService;

    @GetMapping
    public List<CaracteristiqueVoiture> findAll() {
        return caracteristiqueVoitureService.findAll();
    }

    @GetMapping("/{id}")
    public CaracteristiqueVoiture findById(@PathVariable String id) {
        return caracteristiqueVoitureService.findById(id);
    }

    @PostMapping
    public ResponseEntity<CaracteristiqueVoiture> creer(@RequestBody CaracteristiqueVoiture caracteristiqueVoiture) {
        return ResponseEntity.status(HttpStatus.CREATED).body(caracteristiqueVoitureService.creer(caracteristiqueVoiture));
    }

    @PutMapping("/{id}")
    public CaracteristiqueVoiture modifier(@PathVariable String id, @RequestBody CaracteristiqueVoiture caracteristiqueVoiture) {
        return caracteristiqueVoitureService.modifier(id, caracteristiqueVoiture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        caracteristiqueVoitureService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
