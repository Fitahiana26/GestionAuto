package mg.rkmadagascar.gestionautomobile.repository;

import mg.rkmadagascar.gestionautomobile.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    List<Car> findByCategoryId(String categoryId);
    List<Car> findByFuelTypeId(String fuelTypeId);
    List<Car> findByBrandId(String brandId);
    List<Car> findByStatusId(String statusId);
}
