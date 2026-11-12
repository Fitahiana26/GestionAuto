package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Reservation;
import mg.rkmadagascar.gestionautomobile.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public Reservation findById(@PathVariable String id) {
        return reservationService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Reservation> creer(@RequestBody Reservation reservation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.creer(reservation));
    }

    @PutMapping("/{id}")
    public Reservation modifier(@PathVariable String id, @RequestBody Reservation reservation) {
        return reservationService.modifier(id, reservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        reservationService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
