package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Vente;
import mg.rkmadagascar.gestionautomobile.entity.Voiture;
import mg.rkmadagascar.gestionautomobile.repository.VenteRepository;
import mg.rkmadagascar.gestionautomobile.repository.VoitureRepository;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VenteService {

    private final VenteRepository venteRepository;
    private final VoitureRepository voitureRepository;

    public List<Vente> findAll() {
        return venteRepository.findAll();
    }

    public Vente findById(String idVente) {
        return venteRepository.findById(idVente)
                .orElseThrow(() -> new EntityNotFoundException("Vente introuvable : " + idVente));
    }

    @Transactional
    public Vente creer(String idVoiture, BigDecimal prixVente) {
        Voiture voiture = voitureRepository.findById(idVoiture)
                .orElseThrow(() -> new EntityNotFoundException("Voiture introuvable : " + idVoiture));

        if (venteRepository.existsByVoiture_IdVoiture(idVoiture)) {
            throw new IllegalStateException("Cette voiture est déjà vendue");
        }

        Vente vente = new Vente();
        vente.setVoiture(voiture);
        vente.setPrixVente(prixVente);
        vente.setDateVente(LocalDate.now());
        return venteRepository.save(vente);
    }

    @Transactional
    public Vente modifierPrix(String idVente, BigDecimal nouveauPrix) {
        Vente vente = findById(idVente);
        vente.setPrixVente(nouveauPrix);
        return vente; // flush automatique à la fin de la transaction
    }

    @Transactional
    public void supprimer(String idVente) {
        venteRepository.delete(findById(idVente));
    }

    /** Bénéfice = prix de vente - prix d'achat de la voiture. */
    public BigDecimal calculerBenefice(String idVente) {
        Vente vente = findById(idVente);
        return vente.getPrixVente().subtract(vente.getVoiture().getPrixAchat());
    }
}
