package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.TypeMouvement;
import mg.rkmadagascar.gestionautomobile.repository.TypeMouvementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TypeMouvementService {

    private final TypeMouvementRepository typeMouvementRepository;

    public List<TypeMouvement> findAll() {
        return typeMouvementRepository.findAll();
    }

    public TypeMouvement findById(String id) {
        return typeMouvementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TypeMouvement introuvable : " + id));
    }

    @Transactional
    public TypeMouvement creer(TypeMouvement typeMouvement) {
        return typeMouvementRepository.save(typeMouvement);
    }

    @Transactional
    public TypeMouvement modifier(String id, TypeMouvement typeMouvement) {
        findById(id);
        typeMouvement.setIdTypeMvt(id);
        return typeMouvementRepository.save(typeMouvement);
    }

    @Transactional
    public void supprimer(String id) {
        typeMouvementRepository.delete(findById(id));
    }
}
