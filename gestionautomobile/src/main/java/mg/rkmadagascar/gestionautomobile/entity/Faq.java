package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "faq")
@Getter
@Setter
@NoArgsConstructor
public class Faq {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_faq", length = 50)
    private String idFaq;

    @Column(name = "question", columnDefinition = "TEXT")
    private String question;

    @Column(name = "reponse", columnDefinition = "TEXT")
    private String reponse;

    @Column(name = "statut", length = 30)
    private String statut;

}
