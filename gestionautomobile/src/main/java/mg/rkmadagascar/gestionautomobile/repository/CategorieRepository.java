package mg.rkmadagascar.gestionautomobile.repository;

import  mg.rkmadagascar.gestionautomobile.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, String> {
}
