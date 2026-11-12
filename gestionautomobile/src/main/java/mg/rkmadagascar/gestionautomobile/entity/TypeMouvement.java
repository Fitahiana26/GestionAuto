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
@Table(name = "type_mouvement")
@Getter
@Setter
@NoArgsConstructor
public class TypeMouvement {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_type_mvt", length = 50)
    private String idTypeMvt;

    @Column(name = "statut_mvt", length = 20)
    private String statutMvt;

    @JsonIgnore
    @OneToMany(mappedBy = "typeMouvement")
    private List<MouvementStock> mouvementStocks = new ArrayList<>();

}
