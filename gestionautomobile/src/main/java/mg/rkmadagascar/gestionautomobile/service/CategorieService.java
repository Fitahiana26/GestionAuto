package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Categorie;
import mg.rkmadagascar.gestionautomobile.repository.CategorieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    public Categorie findById(String id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categorie introuvable : " + id));
    }

    @Transactional
    public Categorie creer(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Transactional
    public Categorie modifier(String id, Categorie categorie) {
        findById(id);
        categorie.setIdCategorie(id);
        return categorieRepository.save(categorie);
    }

    @Transactional
    public void supprimer(String id) {
        categorieRepository.delete(findById(id));
    }
}
