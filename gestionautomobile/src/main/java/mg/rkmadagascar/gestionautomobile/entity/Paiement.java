package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "paiement")
@Getter
@Setter
@NoArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_paiement", length = 50)
    private String idPaiement;

    @Column(name = "montant", precision = 15, scale = 2)
    private BigDecimal montant;

    @Column(name = "date_payement")
    private LocalDateTime datePayement;

    @Column(name = "reference_payemnt", length = 50)
    private String referencePayement;

    @ManyToOne
    @JoinColumn(name = "id_mode_paiement")
    private ModePaiement modePaiement;

    @ManyToOne
    @JoinColumn(name = "id_vente")
    private Vente vente;

}
