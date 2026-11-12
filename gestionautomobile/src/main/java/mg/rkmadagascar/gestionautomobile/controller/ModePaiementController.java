package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.ModePaiement;
import mg.rkmadagascar.gestionautomobile.service.ModePaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modes-paiement")
@RequiredArgsConstructor
public class ModePaiementController {

    private final ModePaiementService modePaiementService;

    @GetMapping
    public List<ModePaiement> findAll() {
        return modePaiementService.findAll();
    }

    @GetMapping("/{id}")
    public ModePaiement findById(@PathVariable String id) {
        return modePaiementService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ModePaiement> creer(@RequestBody ModePaiement modePaiement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(modePaiementService.creer(modePaiement));
    }

    @PutMapping("/{id}")
    public ModePaiement modifier(@PathVariable String id, @RequestBody ModePaiement modePaiement) {
        return modePaiementService.modifier(id, modePaiement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        modePaiementService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
