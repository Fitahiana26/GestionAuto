package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Reservation;
import mg.rkmadagascar.gestionautomobile.entity.User;
import mg.rkmadagascar.gestionautomobile.repository.ReservationRepository;
import mg.rkmadagascar.gestionautomobile.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository repository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<Reservation> findAllForUser(String email, boolean administrator) {
        return administrator ? repository.findAll() : repository.findByUserEmail(email);
    }

    @Transactional(readOnly = true)
    public Reservation findByIdForUser(String id, String email, boolean administrator) {
        return (administrator ? repository.findById(id) : repository.findByIdAndUserEmail(id, email))
                .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation introuvable : " + id));
    }

    @Transactional
    public Reservation create(Reservation entity, String userEmail) {
        entity.setId(null);
        User owner = userRepository.findByEmail(userEmail).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Utilisateur authentifié introuvable"));
        entity.setUser(owner);
        return repository.save(entity);
    }

    @Transactional
    public Reservation update(String id, Reservation entity) {
        repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation introuvable : " + id));
        entity.setId(id);
        return repository.save(entity);
    }

    @Transactional
    public void delete(String id) {
        repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation introuvable : " + id));
        repository.deleteById(id);
    }
}
