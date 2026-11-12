package mg.rkmadagascar.gestionautomobile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "contact")
@Getter
@Setter
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_contact", length = 50)
    private String idContact;

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

    @Column(name = "maps", length = 50)
    private String maps;

}
