package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Paiement;
import mg.rkmadagascar.gestionautomobile.service.PaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final PaiementService paiementService;

    @GetMapping
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }

    @GetMapping("/{id}")
    public Paiement findById(@PathVariable String id) {
        return paiementService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Paiement> creer(@RequestBody Paiement paiement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paiementService.creer(paiement));
    }

    @PutMapping("/{id}")
    public Paiement modifier(@PathVariable String id, @RequestBody Paiement paiement) {
        return paiementService.modifier(id, paiement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        paiementService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
