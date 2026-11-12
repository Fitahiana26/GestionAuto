package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.StatutPaiement;
import mg.rkmadagascar.gestionautomobile.service.StatutPaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/statuts-paiement")
@RequiredArgsConstructor
public class StatutPaiementController {

    private final StatutPaiementService statutPaiementService;

    @GetMapping
    public List<StatutPaiement> findAll() {
        return statutPaiementService.findAll();
    }

    @GetMapping("/{id}")
    public StatutPaiement findById(@PathVariable String id) {
        return statutPaiementService.findById(id);
    }

    @PostMapping
    public ResponseEntity<StatutPaiement> creer(@RequestBody StatutPaiement statutPaiement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(statutPaiementService.creer(statutPaiement));
    }

    @PutMapping("/{id}")
    public StatutPaiement modifier(@PathVariable String id, @RequestBody StatutPaiement statutPaiement) {
        return statutPaiementService.modifier(id, statutPaiement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        statutPaiementService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
