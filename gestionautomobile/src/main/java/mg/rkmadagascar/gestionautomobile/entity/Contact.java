package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact")
@Getter
@Setter
public class Contact {

    @Id
    @Column(name = "id_contact", length = 50)
    private String id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "telephone", length = 50)
    private String telephone;

    @Column(name = "telephone_secondaire", length = 50)
    private String telephoneSecondaire;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "whatsapp", length = 50)
    private String whatsapp;

    @Column(name = "maps_url", length = 50)
    private String mapsUrl;

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
