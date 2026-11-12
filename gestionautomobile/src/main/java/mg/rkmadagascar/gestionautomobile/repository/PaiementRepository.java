package mg.rkmadagascar.gestionautomobile.repository;

import mg.rkmadagascar.gestionautomobile.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, String> {
}
