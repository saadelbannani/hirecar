package com.project.hirecar.rest.dto.input;

import lombok.Data;

@Data
public class LocationCarInputDto {

    private Integer id;

    private String uuid;

    private String name;

    private String year;

    private String color;

    private String immatriculation;

    private boolean disponibility;

    private BrandInputDto brand;
}
