package mg.rkmadagascar.gestionautomobile.repository;

import mg.rkmadagascar.gestionautomobile.entity.StatutPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutPaiementRepository extends JpaRepository<StatutPaiement, String> {
}
