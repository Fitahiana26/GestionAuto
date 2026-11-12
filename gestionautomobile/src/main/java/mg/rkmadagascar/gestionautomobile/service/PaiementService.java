package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Paiement;
import mg.rkmadagascar.gestionautomobile.repository.PaiementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaiementService {

    private final PaiementRepository paiementRepository;

    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    public Paiement findById(String id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable : " + id));
    }

    @Transactional
    public Paiement creer(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Transactional
    public Paiement modifier(String id, Paiement paiement) {
        findById(id);
        paiement.setIdPaiement(id);
        return paiementRepository.save(paiement);
    }

    @Transactional
    public void supprimer(String id) {
        paiementRepository.delete(findById(id));
    }
}
