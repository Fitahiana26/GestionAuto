package mg.rkmadagascar.gestionautomobile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "mode_paiement")
@Getter
@Setter
@NoArgsConstructor
public class ModePaiement {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_mode_paiement", length = 50)
    private String idModePaiement;

    @Column(name = "type_paiement", length = 50)
    private String typePaiement;

    @JsonIgnore
    @OneToMany(mappedBy = "modePaiement")
    private List<Paiement> paiements = new ArrayList<>();

}
