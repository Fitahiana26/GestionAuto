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
@Table(name = "categorie_depense")
@Getter
@Setter
@NoArgsConstructor
public class CategorieDepense {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_categorie_depense", length = 50)
    private String idCategorieDepense;

    @Column(name = "nom_categorie", length = 50)
    private String nomCategorie;

    @Column(name = "description", length = 100)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "categorieDepense")
    private List<Depense> depenses = new ArrayList<>();

}
