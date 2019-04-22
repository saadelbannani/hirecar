package com.project.hirecar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "BRAND")
public class Brand implements Serializable {

    @Id
    @SequenceGenerator(name = "BRAND_GEN", sequenceName = "BRAND_SEQ", allocationSize = 10)
    @GeneratedValue(generator = "BRAND_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "BRAND_ID", nullable = false)
    @Getter
    private Integer id;

    @Type(type="uuid-char")
    @Column(name = "BRAND_UUID", unique = true, nullable = false)
    @Getter
    private UUID uuid;

    @Column(name = "BRAND_NAME")
    @Getter
    @Setter
    private String name;

    @JsonIgnore
    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,
            mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Car> cars = new ArrayList<>();

    public Brand() {
        this.uuid = UUID.randomUUID();
    }
}