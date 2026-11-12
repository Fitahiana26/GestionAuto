package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "detail_voiture")
@Getter
@Setter
@NoArgsConstructor
public class DetailVoiture {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_detail_voiture", length = 50)
    private String idDetailVoiture;

    @ManyToOne
    @JoinColumn(name = "id_detail")
    private CaracteristiqueVoiture caracteristique;

    @ManyToOne
    @JoinColumn(name = "id_voiture")
    private Voiture voiture;

}
