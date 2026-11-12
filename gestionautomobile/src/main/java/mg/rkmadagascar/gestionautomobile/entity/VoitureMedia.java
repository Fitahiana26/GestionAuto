package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "voiture_media")
@Getter
@Setter
@NoArgsConstructor
public class VoitureMedia {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_media", length = 50)
    private String idMedia;

    @Column(name = "url", length = 100)
    private String url;

    @ManyToOne
    @JoinColumn(name = "id_voiture")
    private Voiture voiture;

}
