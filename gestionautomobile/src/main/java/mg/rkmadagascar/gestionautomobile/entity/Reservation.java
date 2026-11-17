package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_mvt_reservation", nullable = false)
    private MouvementReservation mouvementReservation;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
