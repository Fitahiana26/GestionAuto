package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "statut_paiement")
@Getter
@Setter
@NoArgsConstructor
public class StatutPaiement {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_statut_paiement", length = 50)
    private String idStatutPaiement;

    @Column(name = "libelle", length = 50)
    private String libelle;

}
