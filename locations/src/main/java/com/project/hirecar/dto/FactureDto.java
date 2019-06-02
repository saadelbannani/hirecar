package com.project.hirecar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FactureDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("factureNumber")
    private String factureNumber;

    @JsonProperty("type")
    private String type;

    @JsonProperty("stat")
    private String stat;

    @JsonProperty("price")
    private double price;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("endDate")
    private LocalDate endDate;
}
