package mg.rkmadagascar.gestionautomobile.repository;

import mg.rkmadagascar.gestionautomobile.entity.Expence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenceRepository extends JpaRepository<Expence, String> {

    List<Expence> findByCarId(String carId);
    List<Expence> findByExpenseCategoryId(String expenseCategoryId);
}
