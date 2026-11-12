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
@Table(name = "vente")
@Getter
@Setter
@NoArgsConstructor
public class Vente {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_vente", length = 50)
    private String idVente;

    @Column(name = "prix_vente", precision = 15, scale = 2)
    private BigDecimal prixVente;

    @Column(name = "date_vente")
    private LocalDate dateVente;

    @ManyToOne
    @JoinColumn(name = "id_voiture")
    private Voiture voiture;

    @JsonIgnore
    @OneToMany(mappedBy = "vente")
    private List<Paiement> paiements = new ArrayList<>();

}
