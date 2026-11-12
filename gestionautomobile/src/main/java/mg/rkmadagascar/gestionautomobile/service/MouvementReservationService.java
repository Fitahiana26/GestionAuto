package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.MouvementReservation;
import mg.rkmadagascar.gestionautomobile.repository.MouvementReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MouvementReservationService {

    private final MouvementReservationRepository mouvementReservationRepository;

    public List<MouvementReservation> findAll() {
        return mouvementReservationRepository.findAll();
    }

    public MouvementReservation findById(String id) {
        return mouvementReservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MouvementReservation introuvable : " + id));
    }

    @Transactional
    public MouvementReservation creer(MouvementReservation mouvementReservation) {
        return mouvementReservationRepository.save(mouvementReservation);
    }

    @Transactional
    public MouvementReservation modifier(String id, MouvementReservation mouvementReservation) {
        findById(id);
        mouvementReservation.setIdMvtReservation(id);
        return mouvementReservationRepository.save(mouvementReservation);
    }

    @Transactional
    public void supprimer(String id) {
        mouvementReservationRepository.delete(findById(id));
    }
}
