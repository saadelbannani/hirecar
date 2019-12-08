package com.project.hirecar.stream.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BrandStreamDto {

    private Integer id;

    private UUID uuid;

    private String name;
}
