package com.project.hirecar.controller;

import com.project.hirecar.dto.LocationDto;
import com.project.hirecar.model.Location;
import com.project.hirecar.repository.LocationRepository;
import com.project.hirecar.rest.CallRestTemplate;
import com.project.hirecar.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
@Api(value = "locationstore")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CallRestTemplate callRestTemplate;

    @Autowired
    private LocationService locationService;

    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "View one of available locations", response = Iterable.class)
    @GetMapping(value = "/getbyid/{id}")
    public ResponseEntity<LocationDto> getById(@NotNull @PathVariable Integer id) {
        LocationDto locationDto = locationService.getById(id);
        return new ResponseEntity<>(locationDto, HttpStatus.OK);
    }

    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "View all available locations", response = Iterable.class)
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity<List<Location>> getAll() {
        Optional<List<Location>> locations = Optional.ofNullable(locationRepository.findAll());
        return new ResponseEntity<>(locations.orElse(null), HttpStatus.OK);
    }

    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create new location", response = Iterable.class)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Location> create(@NotNull @RequestBody Location location) {
        Location locationCreated = locationRepository.save(location);
        return new ResponseEntity<>(locationCreated, HttpStatus.CREATED);
    }

    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update existing location", response = Iterable.class)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Integer> update(@NotNull @RequestBody Location location) {
        if (location.getId() != null && locationRepository.exists(location.getId())) {
            Location locationUpdated = locationRepository.save(location);
            return new ResponseEntity<>(locationUpdated.getId(), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
