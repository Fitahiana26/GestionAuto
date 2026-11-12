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
@Table(name = "personne")
@Getter
@Setter
@NoArgsConstructor
public class Personne {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_personne", length = 50)
    private String idPersonne;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "mot_de_passe", length = 50)
    private String motDePasse;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "personne")
    private List<MouvementStock> mouvementStocks = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "personne")
    private List<Reservation> reservations = new ArrayList<>();

}
