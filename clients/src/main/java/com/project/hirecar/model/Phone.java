package com.project.hirecar.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "PHONE")
public class Phone implements Serializable {

    @Id
    @SequenceGenerator(name = "PHONE_GEN", sequenceName = "PHONE_SEQ", allocationSize = 10)
    @GeneratedValue(generator = "PHONE_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "PHONE_ID", nullable = false)
    @Getter
    private Integer id;

    @Type(type="uuid-char")
    @Column(name = "PHONE_UUID", unique = true, nullable = false)
    @Getter
    private UUID uuid;

    @Getter
    @Setter
    @Column(name = "PHONE_PREFIX")
    private String prefix;

    @Getter
    @Setter
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public Phone() {
        this.uuid = UUID.randomUUID();
    }
}
