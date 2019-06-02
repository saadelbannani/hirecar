package com.project.hirecar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.hirecar.rest.dto.input.LocationCarInputDto;
import lombok.Data;

@Data
public class LocationDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("locationNumber")
    private String locationNumber;

    @JsonProperty("car")
    private LocationCarInputDto car;

    @JsonProperty("uuidClient")
    private String uuidClient;

    @JsonProperty("facture")
    private FactureDto facture;
}
