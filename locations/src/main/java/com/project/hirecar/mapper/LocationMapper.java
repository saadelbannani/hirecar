package com.project.hirecar.mapper;

import com.project.hirecar.dto.LocationDto;
import com.project.hirecar.model.Location;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        uses = {FactureMapper.class})
@Named("LocationMapper")
public interface LocationMapper {

    @Mappings(value = {
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "car", ignore = true),
        @Mapping(target = "facture", qualifiedByName = {"FactureMapper", "fromFacture"})
    })
    @Named("fromLocation")
    LocationDto fromLocation(Location location);
}
