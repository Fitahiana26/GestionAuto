package mg.rkmadagascar.gestionautomobile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "email", length = 50)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "contact", length = 50)
    private String contact;

    @Column(name = "picture", length = 100)
    private String picture;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<StockMovement> stockMovements = new ArrayList<>();

        @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<>();

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
