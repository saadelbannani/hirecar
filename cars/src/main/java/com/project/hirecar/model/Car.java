package com.project.hirecar.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "CAR")
public class Car implements Serializable {

	@Id
	@SequenceGenerator(name = "CAR_GEN", sequenceName = "CAR_SEQ", allocationSize = 10)
	@GeneratedValue(generator = "CAR_GEN", strategy = GenerationType.SEQUENCE)
	@Column(name = "CAR_ID", nullable = false)
	@Getter
	private Integer id;

	@Type(type="uuid-char")
	@Column(name = "CAR_UUID", unique = true, nullable = false)
	@Getter
	private UUID uuid;

	@Column(name = "CAR_NAME")
	@Getter
	@Setter
	private String name;

	@Column(name = "CAR_YEAR")
	@Getter
	@Setter
	private String year;

	@Column(name = "CAR_COLOR")
	@Getter
	@Setter
	private String color;

	@Column(name = "CAR_IMMATRICULATION")
	@Getter
	@Setter
	private String immatriculation;

	@Column(name = "CAR_DISPONIBILITY")
	@Getter
	@Setter
	private boolean disponibility;

	@Getter
	@Setter
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CAR_BRAND_ID", nullable = false)
	private Brand brand;

	public Car() {
		this.uuid = UUID.randomUUID();
	}
}