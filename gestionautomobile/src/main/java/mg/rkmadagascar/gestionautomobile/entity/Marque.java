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
@Table(name = "marque")
@Getter
@Setter
@NoArgsConstructor
public class Marque {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_marque", length = 50)
    private String idMarque;

    @Column(name = "nom_marque", length = 50)
    private String nomMarque;

    @JsonIgnore
    @OneToMany(mappedBy = "marque")
    private List<CaracteristiqueVoiture> caracteristiqueVoitures = new ArrayList<>();

}
