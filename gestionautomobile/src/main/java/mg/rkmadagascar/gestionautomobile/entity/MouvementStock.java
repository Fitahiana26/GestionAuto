package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "mouvement_stock")
@Getter
@Setter
@NoArgsConstructor
public class MouvementStock {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_mvt_stock", length = 50)
    private String idMvtStock;

    @Column(name = "quantite")
    private Integer quantite;

    @Column(name = "date_mouvement")
    private LocalDate dateMouvement;

    @ManyToOne
    @JoinColumn(name = "id_personne")
    private Personne personne;

    @ManyToOne
    @JoinColumn(name = "id_type_mvt")
    private TypeMouvement typeMouvement;

    @ManyToOne
    @JoinColumn(name = "id_voiture")
    private Voiture voiture;

}
