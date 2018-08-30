package com.project.hirecar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "LOCATION")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_ID")
    private Integer id;

    @Column(name = "LOCATION_NUMBER")
    private String locationNumber;

    @ManyToOne
    @JoinColumn(name = "LOCATION_CAR_ID", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "LOCATION_CLIENT_ID", nullable = false)
    private Client client;

    @OneToOne(mappedBy = "location")
    private Facture facture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationNumber() {
        return locationNumber;
    }

    public void setLocationNumber(String locationNumber) {
        this.locationNumber = locationNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}
