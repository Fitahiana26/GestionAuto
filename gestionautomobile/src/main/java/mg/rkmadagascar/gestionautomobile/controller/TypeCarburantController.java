package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.TypeCarburant;
import mg.rkmadagascar.gestionautomobile.service.TypeCarburantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/types-carburant")
@RequiredArgsConstructor
public class TypeCarburantController {

    private final TypeCarburantService typeCarburantService;

    @GetMapping
    public List<TypeCarburant> findAll() {
        return typeCarburantService.findAll();
    }

    @GetMapping("/{id}")
    public TypeCarburant findById(@PathVariable String id) {
        return typeCarburantService.findById(id);
    }

    @PostMapping
    public ResponseEntity<TypeCarburant> creer(@RequestBody TypeCarburant typeCarburant) {
        return ResponseEntity.status(HttpStatus.CREATED).body(typeCarburantService.creer(typeCarburant));
    }

    @PutMapping("/{id}")
    public TypeCarburant modifier(@PathVariable String id, @RequestBody TypeCarburant typeCarburant) {
        return typeCarburantService.modifier(id, typeCarburant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        typeCarburantService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
