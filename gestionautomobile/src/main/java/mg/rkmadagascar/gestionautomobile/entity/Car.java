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
@Table(name = "car")
@Getter
@Setter
public class Car {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "model", length = 50)
    private String model;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "date_added")
    private LocalDate dateAdded;

    @Column(name = "purchase_price", precision = 15, scale = 2)
    private BigDecimal purchasePrice;

    @Column(name = "nom_voiture", length = 50)
    private String nomVoiture;

    @Column(name = "years")
    private Integer years;

    @Column(name = "mileage", precision = 15, scale = 2)
    private BigDecimal mileage;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "chassis_number", length = 50)
    private String chassisNumber;

    @Column(name = "consumption", length = 50)
    private String consumption;

    @Column(name = "price", precision = 15, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_fuel_type", nullable = false)
    private FuelType fuelType;

    @ManyToOne
    @JoinColumn(name = "id_brand", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Sale> sales = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Noticed> noticeds = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<CarMedia> carMedias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<StockMovement> stockMovements = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Expence> expences = new ArrayList<>();

    @PrePersist
    void generateId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
