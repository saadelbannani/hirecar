package com.project.hirecar.controller;

import com.project.hirecar.mapper.CarMapper;
import com.project.hirecar.model.Car;
import com.project.hirecar.repository.CarRepository;
import com.project.hirecar.stream.CarStreamService;
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
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/cars")
@Api(value="carsStore")
public class CarController {

    private CarRepository carRepository;

    private CarStreamService carStreamService;

    private CarMapper carMapper;

    @Autowired
    public CarController(CarRepository carRepository, CarStreamService carStreamService,
                         CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carStreamService = carStreamService;
        this.carMapper = carMapper;
    }

    @ApiOperation(value = "View one of available cars", response = Iterable.class)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<Car> getById(@NotNull @PathVariable Integer id) {
        Optional<Car> car = carRepository.findById(id);
        carStreamService.publishCar(carMapper.toCarStreamDto(car.get()));
        return new ResponseEntity<>(car.isPresent() ? car.get() : null, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available cars", response = Iterable.class)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity<List<Car>> getAll() {
        Optional<List<Car>> cars = Optional.ofNullable(carRepository.findAll());
        return new ResponseEntity<>(cars.orElse(null), HttpStatus.OK);
    }

    @ApiOperation(value = "Create a new car", response = Iterable.class)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Car> create(@NotNull @RequestBody Car car) {
        Car carCreated = carRepository.save(car);
        return new ResponseEntity<>(carCreated, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an existing car", response = Iterable.class)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Integer> update(@NotNull @RequestBody Car car) {
        if (car.getId() != null && carRepository.existsById(car.getId())) {
            Car carUpdated = carRepository.save(car);
            return new ResponseEntity<>(carUpdated.getId(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "View one of available cars", response = Iterable.class)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getcarbyuuid/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<Car> getById(@NotNull @PathVariable String uuid) {
        Optional<Car> car = Optional.ofNullable(carRepository.getByUuid(UUID.fromString(uuid)));
        carStreamService.publishCar(carMapper.toCarStreamDto(car.get()));
        return new ResponseEntity<>(car.orElse(null), HttpStatus.OK);
    }
}