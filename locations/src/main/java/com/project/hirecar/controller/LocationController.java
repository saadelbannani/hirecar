package com.project.hirecar.controller;

import com.project.hirecar.model.Location;
import com.project.hirecar.repository.LocationRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
@Api(value = "locationstore", description = "Operations for car renting")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @ApiOperation(value = "View one of available locations", response = Iterable.class)
    @RequestMapping(value = "/getbyid/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> getById(@NotNull @PathVariable Integer id) {
        Optional<Location> location = Optional.ofNullable(locationRepository.findOne(id));
        return new ResponseEntity<>(location.orElse(null), HttpStatus.OK);
    }

    @ApiOperation(value = "View all available locations", response = Iterable.class)
    @RequestMapping(value = "/getall", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> getAll() {
        Optional<List<Location>> locations = Optional.ofNullable(locationRepository.findAll());
        return new ResponseEntity<>(locations.orElse(null), HttpStatus.OK);
    }

    @ApiOperation(value = "Create new location", response = Iterable.class)
    @RequestMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> create(@NotNull @PathVariable Location location) {
        Location locationCreated = locationRepository.save(location);
        return new ResponseEntity<>(locationCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update existing location", response = Iterable.class)
    @RequestMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> update(@NotNull @PathVariable Location location) {
        if (location.getId() != null && locationRepository.exists(location.getId())) {
            Location locationUpdated = locationRepository.save(location);
            return new ResponseEntity<>(locationUpdated.getId(), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
