package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.StatutPaiement;
import mg.rkmadagascar.gestionautomobile.repository.StatutPaiementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StatutPaiementService {

    private final StatutPaiementRepository statutPaiementRepository;

    public List<StatutPaiement> findAll() {
        return statutPaiementRepository.findAll();
    }

    public StatutPaiement findById(String id) {
        return statutPaiementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("StatutPaiement introuvable : " + id));
    }

    @Transactional
    public StatutPaiement creer(StatutPaiement statutPaiement) {
        return statutPaiementRepository.save(statutPaiement);
    }

    @Transactional
    public StatutPaiement modifier(String id, StatutPaiement statutPaiement) {
        findById(id);
        statutPaiement.setIdStatutPaiement(id);
        return statutPaiementRepository.save(statutPaiement);
    }

    @Transactional
    public void supprimer(String id) {
        statutPaiementRepository.delete(findById(id));
    }
}
