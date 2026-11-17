package mg.rkmadagascar.gestionautomobile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mouvement_reservation")
@Getter
@Setter
public class MouvementReservation {

    @Id
    @Column(name = "id_mvt_reservation", length = 50)
    private String id;

    @Column(name = "type_mvt", length = 50)
    private String typeMvt;

    @JsonIgnore
    @OneToMany(mappedBy = "mouvementReservation")
    private List<Reservation> reservations = new ArrayList<>();

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
