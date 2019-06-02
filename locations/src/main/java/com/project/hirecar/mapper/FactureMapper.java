package com.project.hirecar.mapper;

import com.project.hirecar.dto.FactureDto;
import com.project.hirecar.model.Facture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
@Named("factureMapper")
public interface FactureMapper {

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "uuid", target = "uuid"),
            @Mapping(source = "factureNumber", target = "factureNumber"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "stat", target = "stat"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "startDate", target = "startDate"),
            @Mapping(source = "endDate", target = "endDate"),
            @Mapping(target = "location", ignore = true)
    })
    @Named("fromFacture")
    FactureDto fromFacture(Facture facture);
}
