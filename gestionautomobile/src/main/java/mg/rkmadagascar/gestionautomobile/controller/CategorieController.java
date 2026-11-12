package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Categorie;
import mg.rkmadagascar.gestionautomobile.service.CategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategorieController {

    private final CategorieService categorieService;

    @GetMapping
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }

    @GetMapping("/{id}")
    public Categorie findById(@PathVariable String id) {
        return categorieService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Categorie> creer(@RequestBody Categorie categorie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categorieService.creer(categorie));
    }

    @PutMapping("/{id}")
    public Categorie modifier(@PathVariable String id, @RequestBody Categorie categorie) {
        return categorieService.modifier(id, categorie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        categorieService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
