package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.CategorieDepense;
import mg.rkmadagascar.gestionautomobile.repository.CategorieDepenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategorieDepenseService {

    private final CategorieDepenseRepository categorieDepenseRepository;

    public List<CategorieDepense> findAll() {
        return categorieDepenseRepository.findAll();
    }

    public CategorieDepense findById(String id) {
        return categorieDepenseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CategorieDepense introuvable : " + id));
    }

    @Transactional
    public CategorieDepense creer(CategorieDepense categorieDepense) {
        return categorieDepenseRepository.save(categorieDepense);
    }

    @Transactional
    public CategorieDepense modifier(String id, CategorieDepense categorieDepense) {
        findById(id);
        categorieDepense.setIdCategorieDepense(id);
        return categorieDepenseRepository.save(categorieDepense);
    }

    @Transactional
    public void supprimer(String id) {
        categorieDepenseRepository.delete(findById(id));
    }
}
