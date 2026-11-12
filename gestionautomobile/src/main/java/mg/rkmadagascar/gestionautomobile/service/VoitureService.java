package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Voiture;
import mg.rkmadagascar.gestionautomobile.repository.VoitureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VoitureService {

    private final VoitureRepository voitureRepository;

    public List<Voiture> findAll() {
        return voitureRepository.findAll();
    }

    public Voiture findById(String id) {
        return voitureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Voiture introuvable : " + id));
    }

    @Transactional
    public Voiture creer(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @Transactional
    public Voiture modifier(String id, Voiture voiture) {
        findById(id);
        voiture.setIdVoiture(id);
        return voitureRepository.save(voiture);
    }

    @Transactional
    public void supprimer(String id) {
        voitureRepository.delete(findById(id));
    }
}
