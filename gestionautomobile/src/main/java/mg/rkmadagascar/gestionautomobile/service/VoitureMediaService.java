package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.VoitureMedia;
import mg.rkmadagascar.gestionautomobile.repository.VoitureMediaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VoitureMediaService {

    private final VoitureMediaRepository voitureMediaRepository;

    public List<VoitureMedia> findAll() {
        return voitureMediaRepository.findAll();
    }

    public VoitureMedia findById(String id) {
        return voitureMediaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("VoitureMedia introuvable : " + id));
    }

    @Transactional
    public VoitureMedia creer(VoitureMedia voitureMedia) {
        return voitureMediaRepository.save(voitureMedia);
    }

    @Transactional
    public VoitureMedia modifier(String id, VoitureMedia voitureMedia) {
        findById(id);
        voitureMedia.setIdMedia(id);
        return voitureMediaRepository.save(voitureMedia);
    }

    @Transactional
    public void supprimer(String id) {
        voitureMediaRepository.delete(findById(id));
    }
}
