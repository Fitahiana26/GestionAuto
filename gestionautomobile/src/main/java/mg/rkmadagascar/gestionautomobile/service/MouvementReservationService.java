package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.MouvementReservation;
import mg.rkmadagascar.gestionautomobile.repository.MouvementReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MouvementReservationService {

    private final MouvementReservationRepository repository;

    @Transactional(readOnly = true)
    public List<MouvementReservation> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public MouvementReservation findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "MouvementReservation introuvable : " + id));
    }

    @Transactional
    public MouvementReservation create(MouvementReservation entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public MouvementReservation update(String id, MouvementReservation entity) {
        findById(id);
        entity.setId(id);
        return repository.save(entity);
    }

    @Transactional
    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
