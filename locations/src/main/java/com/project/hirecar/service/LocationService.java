package com.project.hirecar.service;

import com.project.hirecar.dto.LocationDto;
import com.project.hirecar.mapper.LocationMapper;
import com.project.hirecar.model.Location;
import com.project.hirecar.repository.LocationRepository;
import com.project.hirecar.rest.CallRestTemplate;
import com.project.hirecar.rest.dto.input.LocationCarInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    private CallRestTemplate callRestTemplate;

    private LocationMapper locationMapper;

    @Autowired
    public LocationService(LocationRepository locationRepository,
                           CallRestTemplate callRestTemplate,
                           LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.callRestTemplate = callRestTemplate;
        this.locationMapper = locationMapper;
    }

    public LocationDto getById(Integer id) {
        LocationDto locationDto = new LocationDto();

        Optional<Location> location = Optional.ofNullable(locationRepository.findOne(id));
        if (location.isPresent()) {
            Location locationCar = location.get();
            locationDto = locationMapper.fromLocation(locationCar);
            locationDto.setCar(getCarRestTemplate(locationCar.getUuid().toString()));
        }

        return locationDto;
    }

    private LocationCarInputDto getCarRestTemplate(String uuid) {
        Optional<LocationCarInputDto> location = Optional.ofNullable(
                callRestTemplate.getCarByUuid(uuid).getBody());
        return location.orElse(null);
    }
}
