package com.project.hirecar.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
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

	@ManyToOne
	@JoinColumn(name = "CAR_MODEL_ID", nullable = false)
	private Model model;
}
