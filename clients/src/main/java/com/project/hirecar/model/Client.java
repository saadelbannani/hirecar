package com.project.hirecar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.hirecar.annotation.LocalDateFormater;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    @SequenceGenerator(name = "CLIENT_GEN", sequenceName = "CLIENT_SEQ", allocationSize = 10)
    @GeneratedValue(generator = "CLIENT_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "CLIENT_ID", nullable = false)
    @Getter
    private Integer id;

    @Type(type="uuid-char")
    @Column(name = "CLIENT_UUID", unique = true, nullable = false)
    @Getter
    private UUID uuid;

    @Getter
    @Setter
    @Column(name = "CLIENT_FNAME")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "CLIENT_LNAME")
    private String lastName;

    @Getter
    @Setter
    @LocalDateFormater
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "CLIENT_DATE_BIRTH")
    private LocalDate dateOfBirth;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private List<Address> addresses = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "PHONE_ID")
    private List<Phone> phones = new ArrayList<>();

    public Client() {
        this.uuid = UUID.randomUUID();
    }
}
