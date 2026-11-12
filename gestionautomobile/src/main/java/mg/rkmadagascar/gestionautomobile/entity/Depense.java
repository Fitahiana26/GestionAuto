package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "depense")
@Getter
@Setter
@NoArgsConstructor
public class Depense {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_depense", length = 50)
    private String idDepense;

    @Column(name = "montant", precision = 15, scale = 2)
    private BigDecimal montant;

    @Column(name = "date_depense")
    private LocalDate dateDepense;

    @Column(name = "description", length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_categorie_depense")
    private CategorieDepense categorieDepense;

}
