package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Depense;
import mg.rkmadagascar.gestionautomobile.repository.DepenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepenseService {

    private final DepenseRepository depenseRepository;

    public List<Depense> findAll() {
        return depenseRepository.findAll();
    }

    public Depense findById(String id) {
        return depenseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Depense introuvable : " + id));
    }

    @Transactional
    public Depense creer(Depense depense) {
        return depenseRepository.save(depense);
    }

    @Transactional
    public Depense modifier(String id, Depense depense) {
        findById(id);
        depense.setIdDepense(id);
        return depenseRepository.save(depense);
    }

    @Transactional
    public void supprimer(String id) {
        depenseRepository.delete(findById(id));
    }
}
