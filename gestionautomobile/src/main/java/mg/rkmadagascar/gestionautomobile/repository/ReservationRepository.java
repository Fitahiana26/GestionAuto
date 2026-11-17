package mg.rkmadagascar.gestionautomobile.repository;

import mg.rkmadagascar.gestionautomobile.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    List<Reservation> findByCarId(String carId);
    List<Reservation> findByStatusId(String statusId);
    List<Reservation> findByMouvementReservationId(String mouvementReservationId);
    List<Reservation> findByUserId(String userId);
    List<Reservation> findByUserEmail(String email);
    java.util.Optional<Reservation> findByIdAndUserEmail(String id, String email);
}
