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
@Getter
@Setter
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID", nullable = false)
    private Integer id;

    @Type(type="uuid-char")
    @Column(name = "BRAND_UUID", unique = true, nullable = false)
    private UUID uuid;

    @Column(name = "BRAND_NAME")
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, mappedBy = "brand")
    private List<Car> models = new ArrayList<>();

    public Brand() {
        this.uuid = UUID.randomUUID();
    }
}