package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.ModePaiement;
import mg.rkmadagascar.gestionautomobile.repository.ModePaiementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ModePaiementService {

    private final ModePaiementRepository modePaiementRepository;

    public List<ModePaiement> findAll() {
        return modePaiementRepository.findAll();
    }

    public ModePaiement findById(String id) {
        return modePaiementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ModePaiement introuvable : " + id));
    }

    @Transactional
    public ModePaiement creer(ModePaiement modePaiement) {
        return modePaiementRepository.save(modePaiement);
    }

    @Transactional
    public ModePaiement modifier(String id, ModePaiement modePaiement) {
        findById(id);
        modePaiement.setIdModePaiement(id);
        return modePaiementRepository.save(modePaiement);
    }

    @Transactional
    public void supprimer(String id) {
        modePaiementRepository.delete(findById(id));
    }
}
