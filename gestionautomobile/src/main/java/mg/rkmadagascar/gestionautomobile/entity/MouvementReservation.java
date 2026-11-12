package mg.rkmadagascar.gestionautomobile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "mouvement_reservation")
@Getter
@Setter
@NoArgsConstructor
public class MouvementReservation {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_mvt_reservation", length = 50)
    private String idMvtReservation;

    @Column(name = "type_mvt", length = 50)
    private String typeMvt;

    @JsonIgnore
    @OneToMany(mappedBy = "mouvementReservation")
    private List<Reservation> reservations = new ArrayList<>();

}
