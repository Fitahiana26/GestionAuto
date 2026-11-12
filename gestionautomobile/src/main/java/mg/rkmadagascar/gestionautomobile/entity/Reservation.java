package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_reservation", length = 50)
    private String idReservation;

    @Column(name = "date_reservation")
    private LocalDate dateReservation;

    @Column(name = "date_expiration")
    private LocalDate dateExpiration;

    @ManyToOne
    @JoinColumn(name = "id_personne")
    private Personne personne;

    @ManyToOne
    @JoinColumn(name = "id_voiture")
    private Voiture voiture;

    @ManyToOne
    @JoinColumn(name = "id_mvt_reservation")
    private MouvementReservation mouvementReservation;

}
