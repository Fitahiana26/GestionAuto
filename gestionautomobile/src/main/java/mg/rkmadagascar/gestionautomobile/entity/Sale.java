package mg.rkmadagascar.gestionautomobile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sale")
@Getter
@Setter
public class Sale {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "selling_price", precision = 15, scale = 2)
    private BigDecimal sellingPrice;

    @Column(name = "date_of_sale")
    private LocalDate dateOfSale;

    @ManyToOne
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;

    @JsonIgnore
    @OneToMany(mappedBy = "sale")
    private List<Payment> payments = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "sale")
    private List<Document> documents = new ArrayList<>();

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
