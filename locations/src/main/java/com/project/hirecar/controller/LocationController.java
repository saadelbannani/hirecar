package com.project.hirecar.controller;

import com.project.hirecar.model.Location;
import com.project.hirecar.repository.LocationRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/location")
@Api(value = "locationstore", description = "Operations for car renting")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @ApiOperation(value = "View one of available locations", response = Iterable.class)
    @RequestMapping(value = "/getbyid/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> getById(Integer id) {
        Optional<Location> location = Optional.ofNullable(locationRepository.findOne(id));
        return new ResponseEntity<>(location.isPresent() ? location.get() : null, HttpStatus.OK);
    }
}
