package mg.rkmadagascar.gestionautomobile.repository;

import mg.rkmadagascar.gestionautomobile.entity.CarMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarMediaRepository extends JpaRepository<CarMedia, String> {

    List<CarMedia> findByCarId(String carId);
}
