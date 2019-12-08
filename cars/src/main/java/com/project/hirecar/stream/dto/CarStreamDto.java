package com.project.hirecar.stream.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CarStreamDto {

    private Integer id;

    private UUID uuid;

    private String name;

    private String year;

    private String color;

    private String immatriculation;

    private BrandStreamDto brand;
}
