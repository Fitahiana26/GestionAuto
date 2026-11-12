package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.CategorieDepense;
import mg.rkmadagascar.gestionautomobile.service.CategorieDepenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories-depense")
@RequiredArgsConstructor
public class CategorieDepenseController {

    private final CategorieDepenseService categorieDepenseService;

    @GetMapping
    public List<CategorieDepense> findAll() {
        return categorieDepenseService.findAll();
    }

    @GetMapping("/{id}")
    public CategorieDepense findById(@PathVariable String id) {
        return categorieDepenseService.findById(id);
    }

    @PostMapping
    public ResponseEntity<CategorieDepense> creer(@RequestBody CategorieDepense categorieDepense) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categorieDepenseService.creer(categorieDepense));
    }

    @PutMapping("/{id}")
    public CategorieDepense modifier(@PathVariable String id, @RequestBody CategorieDepense categorieDepense) {
        return categorieDepenseService.modifier(id, categorieDepense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        categorieDepenseService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
