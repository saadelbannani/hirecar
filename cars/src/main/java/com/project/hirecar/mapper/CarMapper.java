package com.project.hirecar.mapper;

import com.project.hirecar.model.Car;
import com.project.hirecar.stream.dto.CarStreamDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface CarMapper {

    @Mappings({})
    CarStreamDto toCarStreamDto(Car car);
}