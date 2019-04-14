package com.project.hirecar.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "CAR")
@Getter
@Setter
public class Car implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAR_ID", nullable = false)
	private Integer id;

	@Type(type="uuid-char")
	@Column(name = "CAR_UUID", unique = true, nullable = false)
	private UUID uuid;

	@Column(name = "CAR_NAME")
	private String name;

	@Column(name = "CAR_YEAR")
	private String year;

	@Column(name = "CAR_COLOR")
	private String color;

	@Column(name = "CAR_IMMATRICULATION")
	private String immatriculation;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "CAR_BRAND_ID")
	private Brand brand;

	public Car() {
		this.uuid = UUID.randomUUID();
	}
}