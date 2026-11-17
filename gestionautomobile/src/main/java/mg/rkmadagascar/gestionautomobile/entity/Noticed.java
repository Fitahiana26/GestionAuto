package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "noticed")
@Getter
@Setter
public class Noticed {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "libelle", length = 150)
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
