package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car_media")
@Getter
@Setter
public class CarMedia {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "url", length = 100)
    private String url;

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
