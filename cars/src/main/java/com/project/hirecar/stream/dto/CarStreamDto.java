package com.project.hirecar.stream.dto;

import lombok.Data;

@Data
public class CarStreamDto {

    private Integer id;

    private String uuid;

    private String name;

    private String year;

    private String color;

    private String immatriculation;

    private BrandStreamDto brand;
}
