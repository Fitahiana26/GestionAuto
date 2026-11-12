package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.MouvementReservation;
import mg.rkmadagascar.gestionautomobile.service.MouvementReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mouvements-reservation")
@RequiredArgsConstructor
public class MouvementReservationController {

    private final MouvementReservationService mouvementReservationService;

    @GetMapping
    public List<MouvementReservation> findAll() {
        return mouvementReservationService.findAll();
    }

    @GetMapping("/{id}")
    public MouvementReservation findById(@PathVariable String id) {
        return mouvementReservationService.findById(id);
    }

    @PostMapping
    public ResponseEntity<MouvementReservation> creer(@RequestBody MouvementReservation mouvementReservation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mouvementReservationService.creer(mouvementReservation));
    }

    @PutMapping("/{id}")
    public MouvementReservation modifier(@PathVariable String id, @RequestBody MouvementReservation mouvementReservation) {
        return mouvementReservationService.modifier(id, mouvementReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        mouvementReservationService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
