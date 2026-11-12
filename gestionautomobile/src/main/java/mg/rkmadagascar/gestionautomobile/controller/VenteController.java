package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.Vente;
import mg.rkmadagascar.gestionautomobile.service.VenteService;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventes")
@RequiredArgsConstructor
public class VenteController {

    private final VenteService venteService;

    public record VenteRequest(String idVoiture, BigDecimal prixVente) {}

    public record PrixRequest(BigDecimal prixVente) {}

    @GetMapping
    public List<Vente> findAll() {
        return venteService.findAll();
    }

    @GetMapping("/{id}")
    public Vente findById(@PathVariable String id) {
        return venteService.findById(id);
    }

    @GetMapping("/{id}/benefice")
    public BigDecimal benefice(@PathVariable String id) {
        return venteService.calculerBenefice(id);
    }

    @PostMapping
    public ResponseEntity<Vente> creer(@RequestBody VenteRequest request) {
        Vente vente = venteService.creer(request.idVoiture(), request.prixVente());
        return ResponseEntity.status(HttpStatus.CREATED).body(vente);
    }

    @PutMapping("/{id}/prix")
    public Vente modifierPrix(@PathVariable String id, @RequestBody PrixRequest request) {
        return venteService.modifierPrix(id, request.prixVente());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        venteService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
