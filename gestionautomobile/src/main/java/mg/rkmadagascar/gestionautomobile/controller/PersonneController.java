package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Personne;
import mg.rkmadagascar.gestionautomobile.service.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personnes")
@RequiredArgsConstructor
public class PersonneController {

    private final PersonneService personneService;

    @GetMapping
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    @GetMapping("/{id}")
    public Personne findById(@PathVariable String id) {
        return personneService.findById(id);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Personne> findByEmail(@PathVariable String email) {
        return personneService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Personne> creer(@RequestBody Personne personne) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personneService.creer(personne));
    }

    @PutMapping("/{id}")
    public Personne modifier(@PathVariable String id, @RequestBody Personne personne) {
        return personneService.modifier(id, personne);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        personneService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
