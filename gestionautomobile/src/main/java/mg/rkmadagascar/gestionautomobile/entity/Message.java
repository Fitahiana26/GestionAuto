package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "message")
@Getter
@Setter
public class Message {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        if (date == null) {
            date = LocalDateTime.now();
        }
    }
}