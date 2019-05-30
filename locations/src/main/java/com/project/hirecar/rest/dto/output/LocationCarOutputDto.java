package com.project.hirecar.rest.dto.output;

import lombok.Data;

@Data
public class LocationCarOutputDto {

    private Integer id;

    private String uuid;

    private String name;

    private String year;

    private String color;

    private String immatriculation;

    private boolean disponibility;

    private BrandOutputDto brand;
}
