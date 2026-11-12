package mg.rkmadagascar.gestionautomobile.repository;

import mg.rkmadagascar.gestionautomobile.entity.VoitureMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureMediaRepository extends JpaRepository<VoitureMedia, String> {
}
