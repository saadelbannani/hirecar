package com.project.hirecar.mapper;

import com.project.hirecar.model.Brand;
import com.project.hirecar.stream.dto.BrandStreamDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
@Named("BrandMapper")
public interface BrandMapper {

    @Mappings({})
    @Named("toBrandStreamDto")
    BrandStreamDto toBrandStreamDto(Brand brand);
}