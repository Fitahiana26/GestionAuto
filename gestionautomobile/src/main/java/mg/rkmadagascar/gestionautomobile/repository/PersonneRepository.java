package mg.rkmadagascar.gestionautomobile.repository;

import mg.rkmadagascar.gestionautomobile.entity.Personne;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, String> {

    Optional<Personne> findByEmail(String email);
}
