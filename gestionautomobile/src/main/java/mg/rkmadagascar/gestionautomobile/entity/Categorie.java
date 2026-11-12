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
@Table(name = "categorie")
@Getter
@Setter
@NoArgsConstructor
public class Categorie {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_categorie", length = 50)
    private String idCategorie;

    @Column(name = "nom_categorie", length = 50)
    private String nomCategorie;

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private List<CaracteristiqueVoiture> caracteristiqueVoitures = new ArrayList<>();

}
