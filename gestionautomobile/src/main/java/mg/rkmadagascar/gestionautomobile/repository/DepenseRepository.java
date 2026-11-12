package mg.rkmadagascar.gestionautomobile.repository;

import mg.rkmadagascar.gestionautomobile.entity.Depense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, String> {
}
