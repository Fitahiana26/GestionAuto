package mg.rkmadagascar.gestionautomobile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "expense_category")
@Getter
@Setter
public class ExpenseCategory {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "name_category", length = 50)
    private String nameCategory;

    @Column(name = "noticed", length = 50)
    private String noticed;

    @JsonIgnore
    @OneToMany(mappedBy = "expenseCategory")
    private List<Expence> expences = new ArrayList<>();

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
