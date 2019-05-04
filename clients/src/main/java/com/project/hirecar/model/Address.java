package com.project.hirecar.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "ADDRESS_GEN", sequenceName = "ADDRESS_SEQ", allocationSize = 10)
    @GeneratedValue(generator = "ADDRESS_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ADDRESS_ID", nullable = false)
    @Getter
    private Integer id;

    @Type(type="uuid-char")
    @Column(name = "ADDRESS_UUID", unique = true, nullable = false)
    @Getter
    private UUID uuid;

    @Getter
    @Setter
    @Column(name = "ADDRESS_NUMBER")
    private String number;

    @Getter
    @Setter
    @Column(name = "ADDRESS_LINE")
    private String addressLine;

    @Getter
    @Setter
    @Column(name = "ADDRESS_ZIP_CODE")
    private String zipCode;

    @Getter
    @Setter
    @Column(name = "ADDRESS_CITY")
    private String city;

    @Getter
    @Setter
    @Column(name = "ADDRESS_COUNTRY")
    private String country;

    public Address() {
        this.uuid = UUID.randomUUID();
    }
}
