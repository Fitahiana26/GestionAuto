package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "expence")
@Getter
@Setter
public class Expence {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "rising", length = 50)
    private String rising;

    @Column(name = "expence_date")
    private LocalDate expenceDate;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "noticed", length = 50)
    private String noticed;

    @ManyToOne
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_expense_category", nullable = false)
    private ExpenseCategory expenseCategory;

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
