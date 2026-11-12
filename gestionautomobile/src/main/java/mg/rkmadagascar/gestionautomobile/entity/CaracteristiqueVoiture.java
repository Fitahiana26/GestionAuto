package mg.rkmadagascar.gestionautomobile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.*;



@Entity
@Table(name = "caracteristique_voiture")
@Getter
@Setter
@NoArgsConstructor
public class CaracteristiqueVoiture {

    @Id
    @GeneratedValue

    @Column(name = "id_detail", length = 50)
    private String idDetail;

    @Column(name = "annee")
    private Integer annee;

    @Column(name = "consommation", precision = 15, scale = 2)
    private BigDecimal consommation;

    @Column(name = "nombre_porte")
    private Integer nombrePorte;

    @Column(name = "nombre_place")
    private Integer nombrePlace;

    @Column(name = "model", length = 50)
    private String model;

    @Column(name = "puissance", length = 50)
    private String puissance;

    @Column(name = "kilometrage", precision = 5, scale = 2)
    private BigDecimal kilometrage;

    @Column(name = "couleur", length = 20)
    private String couleur;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "id_marque")
    private Marque marque;

    @ManyToOne
    @JoinColumn(name = "id_carburant")
    private TypeCarburant carburant;

    @JsonIgnore
    @OneToMany(mappedBy = "caracteristique")
    private List<DetailVoiture> detailVoitures = new ArrayList<>();

}
