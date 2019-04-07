package com.project.hirecar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "MODEL")
@Getter
@Setter
public class Model implements Serializable {

    @Id
    @Column(name = "MODEL_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "MODEL_UUID", unique = true, nullable = false)
    private UUID uuid;

    @Column(name = "MODEL_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "MODEL_BRAND_ID", nullable = false)
    private Brand brand;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model", orphanRemoval = true)
    private List<Car> cars = new ArrayList<>();
}
