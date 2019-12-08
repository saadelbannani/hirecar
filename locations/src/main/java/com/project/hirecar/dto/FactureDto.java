package com.project.hirecar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class FactureDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("uuid")
    private UUID uuid;

    @JsonProperty("factureNumber")
    private String factureNumber;

    @JsonProperty("type")
    private String type;

    @JsonProperty("stat")
    private String stat;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("endDate")
    private LocalDate endDate;
}
