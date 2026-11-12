package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.CaracteristiqueVoiture;
import mg.rkmadagascar.gestionautomobile.repository.CaracteristiqueVoitureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CaracteristiqueVoitureService {

    private final CaracteristiqueVoitureRepository caracteristiqueVoitureRepository;

    public List<CaracteristiqueVoiture> findAll() {
        return caracteristiqueVoitureRepository.findAll();
    }

    public CaracteristiqueVoiture findById(String id) {
        return caracteristiqueVoitureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CaracteristiqueVoiture introuvable : " + id));
    }

    @Transactional
    public CaracteristiqueVoiture creer(CaracteristiqueVoiture caracteristiqueVoiture) {
        return caracteristiqueVoitureRepository.save(caracteristiqueVoiture);
    }

    @Transactional
    public CaracteristiqueVoiture modifier(String id, CaracteristiqueVoiture caracteristiqueVoiture) {
        findById(id);
        caracteristiqueVoiture.setIdDetail(id);
        return caracteristiqueVoitureRepository.save(caracteristiqueVoiture);
    }

    @Transactional
    public void supprimer(String id) {
        caracteristiqueVoitureRepository.delete(findById(id));
    }
}
