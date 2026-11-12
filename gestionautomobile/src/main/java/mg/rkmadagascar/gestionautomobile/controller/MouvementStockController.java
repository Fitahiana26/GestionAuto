package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.MouvementStock;
import mg.rkmadagascar.gestionautomobile.service.MouvementStockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mouvements-stock")
@RequiredArgsConstructor
public class MouvementStockController {

    private final MouvementStockService mouvementStockService;

    @GetMapping
    public List<MouvementStock> findAll() {
        return mouvementStockService.findAll();
    }

    @GetMapping("/{id}")
    public MouvementStock findById(@PathVariable String id) {
        return mouvementStockService.findById(id);
    }

    @PostMapping
    public ResponseEntity<MouvementStock> creer(@RequestBody MouvementStock mouvementStock) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mouvementStockService.creer(mouvementStock));
    }

    @PutMapping("/{id}")
    public MouvementStock modifier(@PathVariable String id, @RequestBody MouvementStock mouvementStock) {
        return mouvementStockService.modifier(id, mouvementStock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        mouvementStockService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
