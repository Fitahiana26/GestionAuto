package mg.rkmadagascar.gestionautomobile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "voiture")
@Getter
@Setter
@NoArgsConstructor
public class Voiture {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_voiture", length = 50)
    private String idVoiture;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "date_ajoute")
    private LocalDate dateAjoute;

    @Column(name = "prix_achat", precision = 15, scale = 2)
    private BigDecimal prixAchat;

    @JsonIgnore
    @OneToMany(mappedBy = "voiture")
    private List<Vente> ventes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "voiture")
    private List<VoitureMedia> voitureMedias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "voiture")
    private List<DetailVoiture> detailVoitures = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "voiture")
    private List<MouvementStock> mouvementStocks = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "voiture")
    private List<Reservation> reservations = new ArrayList<>();

}
