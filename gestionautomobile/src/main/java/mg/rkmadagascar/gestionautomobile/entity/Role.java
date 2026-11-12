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
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_role", length = 50)
    private String idRole;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<Personne> personnes = new ArrayList<>();

}
