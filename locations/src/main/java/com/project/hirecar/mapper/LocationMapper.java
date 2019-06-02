package com.project.hirecar.mapper;

import com.project.hirecar.dto.LocationDto;
import com.project.hirecar.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {FactureMapper.class})
@Named("locationMapper")
public interface LocationMapper {

    @Mappings(value = {
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "uuid", target = "uuid"),
        @Mapping(source = "locationNumber", target = "locationNumber"),
        @Mapping(target = "uuidCar", ignore = true),
        @Mapping(source = "uuidClient", target = "uuidClient"),
        @Mapping(target = "facture", qualifiedByName = {"factureMapper", "fromFacture"})
    })
    @Named("fromLocation")
    LocationDto fromLocation(Location location);
}
