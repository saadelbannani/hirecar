package com.project.hirecar.mapper;

import com.project.hirecar.model.Car;
import com.project.hirecar.stream.dto.CarStreamDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        uses = {BrandMapper.class})
public interface CarMapper {

    @Mappings({
            @Mapping(source = "brand", target = "brand",
                    qualifiedByName = {"BrandMapper", "toBrandStreamDto"})})
    CarStreamDto toCarStreamDto(Car car);
}