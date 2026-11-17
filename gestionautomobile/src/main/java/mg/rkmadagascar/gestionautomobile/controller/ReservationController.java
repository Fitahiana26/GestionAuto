package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.Reservation;
import mg.rkmadagascar.gestionautomobile.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService service;

    @GetMapping
    public List<Reservation> getAll(Authentication authentication) {
        return service.findAllForUser(authentication.getName(), isAdministrator(authentication));
    }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable String id, Authentication authentication) {
        return service.findByIdForUser(id, authentication.getName(), isAdministrator(authentication));
    }

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody Reservation entity, Authentication authentication) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity, authentication.getName()));
    }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable String id, @RequestBody Reservation entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private boolean isAdministrator(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
    }
}
