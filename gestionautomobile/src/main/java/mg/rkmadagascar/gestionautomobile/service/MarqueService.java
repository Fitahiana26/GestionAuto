package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Marque;
import mg.rkmadagascar.gestionautomobile.repository.MarqueRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarqueService {

    private final MarqueRepository marqueRepository;

    public List<Marque> findAll() {
        return marqueRepository.findAll();
    }

    public Marque findById(String id) {
        return marqueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Marque introuvable : " + id));
    }

    @Transactional
    public Marque creer(Marque marque) {
        return marqueRepository.save(marque);
    }

    @Transactional
    public Marque modifier(String id, Marque marque) {
        findById(id);
        marque.setIdMarque(id);
        return marqueRepository.save(marque);
    }

    @Transactional
    public void supprimer(String id) {
        marqueRepository.delete(findById(id));
    }
}
