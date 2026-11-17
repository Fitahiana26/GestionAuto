package mg.rkmadagascar.gestionautomobile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movement_type")
@Getter
@Setter
public class MovementType {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "movement_type", length = 20)
    private String movementType;

    @JsonIgnore
    @OneToMany(mappedBy = "movementType")
    private List<StockMovement> stockMovements = new ArrayList<>();

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
