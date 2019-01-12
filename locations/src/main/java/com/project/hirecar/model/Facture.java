package com.project.hirecar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.hirecar.annotation.LocalDateFormater;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "FACTURE")
public class Facture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACTURE_ID")
    private Integer id;

    @Column(name = "FACTURE_NUMBER")
    private String factureNumber;

    @Column(name = "FACTURE_TYPE")
    private String type;

    @Column(name = "FACTURE_STAT")
    private String stat;

    @Column(name = "FACTURE_PRICE")
    private double price;

    @LocalDateFormater
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FACTURE_START_DATE")
    private LocalDate startDate;

    @LocalDateFormater
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FACTURE_END_DATE")
    private LocalDate endDate;

    @OneToOne
    @JoinColumn(name = "FACTURE_LOCATION_ID")
    private Location location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactureNumber() {
        return factureNumber;
    }

    public void setFactureNumber(String factureNumber) {
        this.factureNumber = factureNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
