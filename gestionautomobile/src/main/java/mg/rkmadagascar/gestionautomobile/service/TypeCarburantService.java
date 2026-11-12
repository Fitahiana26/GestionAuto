package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.TypeCarburant;
import mg.rkmadagascar.gestionautomobile.repository.TypeCarburantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TypeCarburantService {

    private final TypeCarburantRepository typeCarburantRepository;

    public List<TypeCarburant> findAll() {
        return typeCarburantRepository.findAll();
    }

    public TypeCarburant findById(String id) {
        return typeCarburantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TypeCarburant introuvable : " + id));
    }

    @Transactional
    public TypeCarburant creer(TypeCarburant typeCarburant) {
        return typeCarburantRepository.save(typeCarburant);
    }

    @Transactional
    public TypeCarburant modifier(String id, TypeCarburant typeCarburant) {
        findById(id);
        typeCarburant.setIdCarburant(id);
        return typeCarburantRepository.save(typeCarburant);
    }

    @Transactional
    public void supprimer(String id) {
        typeCarburantRepository.delete(findById(id));
    }
}
