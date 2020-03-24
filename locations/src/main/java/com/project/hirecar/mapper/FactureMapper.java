package com.project.hirecar.mapper;

import com.project.hirecar.dto.FactureDto;
import com.project.hirecar.model.Facture;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface FactureMapper {

    @Mappings(value = {
            @Mapping(target = "id", ignore = true)
    })
    FactureDto fromFacture(Facture facture);
}