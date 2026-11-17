package mg.rkmadagascar.gestionautomobile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment_category")
@Getter
@Setter
public class PaymentCategory {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "payment_category", length = 50)
    private String paymentCategory;

    @JsonIgnore
    @OneToMany(mappedBy = "paymentCategory")
    private List<Payment> payments = new ArrayList<>();

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
