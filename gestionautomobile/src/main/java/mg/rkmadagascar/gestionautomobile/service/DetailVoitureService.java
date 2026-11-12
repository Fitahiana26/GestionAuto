package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.DetailVoiture;
import mg.rkmadagascar.gestionautomobile.repository.DetailVoitureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DetailVoitureService {

    private final DetailVoitureRepository detailVoitureRepository;

    public List<DetailVoiture> findAll() {
        return detailVoitureRepository.findAll();
    }

    public DetailVoiture findById(String id) {
        return detailVoitureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DetailVoiture introuvable : " + id));
    }

    @Transactional
    public DetailVoiture creer(DetailVoiture detailVoiture) {
        return detailVoitureRepository.save(detailVoiture);
    }

    @Transactional
    public DetailVoiture modifier(String id, DetailVoiture detailVoiture) {
        findById(id);
        detailVoiture.setIdDetailVoiture(id);
        return detailVoitureRepository.save(detailVoiture);
    }

    @Transactional
    public void supprimer(String id) {
        detailVoitureRepository.delete(findById(id));
    }
}
