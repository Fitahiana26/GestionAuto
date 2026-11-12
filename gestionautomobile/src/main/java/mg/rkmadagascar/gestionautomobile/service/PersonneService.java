package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Personne;
import mg.rkmadagascar.gestionautomobile.repository.PersonneRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonneService {

    private final PersonneRepository personneRepository;

    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    public Personne findById(String id) {
        return personneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Personne introuvable : " + id));
    }

    public Optional<Personne> findByEmail(String email) {
        return personneRepository.findByEmail(email);
    }

    @Transactional
    public Personne creer(Personne personne) {
        return personneRepository.save(personne);
    }

    @Transactional
    public Personne modifier(String id, Personne personne) {
        findById(id);
        personne.setIdPersonne(id);
        return personneRepository.save(personne);
    }

    @Transactional
    public void supprimer(String id) {
        personneRepository.delete(findById(id));
    }
}
