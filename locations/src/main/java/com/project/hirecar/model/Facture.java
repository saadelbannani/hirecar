package com.project.hirecar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.hirecar.annotation.LocalDateFormater;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "FACTURE")
public class Facture implements Serializable {

    @Id
    @SequenceGenerator(name = "FACTURE_GEN", sequenceName = "FACTURE_SEQ", allocationSize = 10)
    @GeneratedValue(generator = "FACTURE_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "FACTURE_ID", nullable = false)
    @Getter
    private Integer id;

    @Type(type="uuid-char")
    @Column(name = "FACTURE_UUID", unique = true, nullable = false)
    @Getter
    private UUID uuid;

    @Getter
    @Setter
    @Column(name = "FACTURE_NUMBER")
    private String factureNumber;

    @Getter
    @Setter
    @Column(name = "FACTURE_TYPE")
    private String type;

    @Getter
    @Setter
    @Column(name = "FACTURE_STAT")
    private String stat;

    @Getter
    @Setter
    @Column(name = "FACTURE_PRICE")
    private double price;

    @Getter
    @Setter
    @LocalDateFormater
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FACTURE_START_DATE")
    private LocalDate startDate;

    @Getter
    @Setter
    @LocalDateFormater
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FACTURE_END_DATE")
    private LocalDate endDate;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "FACTURE_LOCATION_ID")
    private Location location;

    public Facture() {
        this.uuid = UUID.randomUUID();
    }
}
