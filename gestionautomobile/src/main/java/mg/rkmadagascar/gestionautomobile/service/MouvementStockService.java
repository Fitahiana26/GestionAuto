package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.MouvementStock;
import mg.rkmadagascar.gestionautomobile.repository.MouvementStockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MouvementStockService {

    private final MouvementStockRepository mouvementStockRepository;

    public List<MouvementStock> findAll() {
        return mouvementStockRepository.findAll();
    }

    public MouvementStock findById(String id) {
        return mouvementStockRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MouvementStock introuvable : " + id));
    }

    @Transactional
    public MouvementStock creer(MouvementStock mouvementStock) {
        return mouvementStockRepository.save(mouvementStock);
    }

    @Transactional
    public MouvementStock modifier(String id, MouvementStock mouvementStock) {
        findById(id);
        mouvementStock.setIdMvtStock(id);
        return mouvementStockRepository.save(mouvementStock);
    }

    @Transactional
    public void supprimer(String id) {
        mouvementStockRepository.delete(findById(id));
    }
}
