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
@Table(name = "type_carburant")
@Getter
@Setter
@NoArgsConstructor
public class TypeCarburant {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_carburant", length = 50)
    private String idCarburant;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "carburant")
    private List<CaracteristiqueVoiture> caracteristiqueVoitures = new ArrayList<>();

}
