package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Reservation;
import mg.rkmadagascar.gestionautomobile.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation findById(String id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation introuvable : " + id));
    }

    @Transactional
    public Reservation creer(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Transactional
    public Reservation modifier(String id, Reservation reservation) {
        findById(id);
        reservation.setIdReservation(id);
        return reservationRepository.save(reservation);
    }

    @Transactional
    public void supprimer(String id) {
        reservationRepository.delete(findById(id));
    }
}
