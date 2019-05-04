package com.project.hirecar.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "LOCATION")
public class Location implements Serializable {

    @Id
    @SequenceGenerator(name = "LOCATION_GEN", sequenceName = "LOCATION_SEQ", allocationSize = 10)
    @GeneratedValue(generator = "LOCATION_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "LOCATION_ID", nullable = false)
    @Getter
    private Integer id;

    @Type(type = "uuid-char")
    @Column(name = "LOCATION_UUID", unique = true, nullable = false)
    @Getter
    private UUID uuid;

    @Getter
    @Setter
    @Column(name = "LOCATION_NUMBER")
    private String locationNumber;

    @Getter
    @Setter
    @Type(type = "uuid-char")
    @Column(name = "LOCATION_CAR_UUID", nullable = false)
    private UUID uuidCar;

    @Getter
    @Setter
    @Type(type = "uuid-char")
    @Column(name = "LOCATION_CLIENT_UUID", nullable = false)
    private UUID uuidClient;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "LOCATION_FACTURE_ID")
    private Facture facture;

    public Location() {
        this.uuid = UUID.randomUUID();
    }
}
