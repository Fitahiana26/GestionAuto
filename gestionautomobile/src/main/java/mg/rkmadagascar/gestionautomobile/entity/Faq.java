package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "faq")
@Getter
@Setter
public class Faq {

    @Id
    @Column(name = "id_faq", length = 50)
    private String id;

    @Column(name = "question", columnDefinition = "TEXT")
    private String question;

    @Column(name = "reponse", columnDefinition = "TEXT")
    private String reponse;

    @Column(name = "statut", length = 30)
    private String statut;

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
