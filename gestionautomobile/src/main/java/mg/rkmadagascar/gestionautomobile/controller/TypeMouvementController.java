package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.TypeMouvement;
import mg.rkmadagascar.gestionautomobile.service.TypeMouvementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/types-mouvement")
@RequiredArgsConstructor
public class TypeMouvementController {

    private final TypeMouvementService typeMouvementService;

    @GetMapping
    public List<TypeMouvement> findAll() {
        return typeMouvementService.findAll();
    }

    @GetMapping("/{id}")
    public TypeMouvement findById(@PathVariable String id) {
        return typeMouvementService.findById(id);
    }

    @PostMapping
    public ResponseEntity<TypeMouvement> creer(@RequestBody TypeMouvement typeMouvement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(typeMouvementService.creer(typeMouvement));
    }

    @PutMapping("/{id}")
    public TypeMouvement modifier(@PathVariable String id, @RequestBody TypeMouvement typeMouvement) {
        return typeMouvementService.modifier(id, typeMouvement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        typeMouvementService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
