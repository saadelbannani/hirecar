package com.project.hirecar.controller;

import com.project.hirecar.model.Car;
import com.project.hirecar.repository.CarRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/car")
@Api(value="carstore", description="Operations for car renting")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @ApiOperation(value = "View one of available cars", response = Iterable.class)
    @RequestMapping(value = "/getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Car> getById(@NotNull @PathVariable Integer id) {
        Optional<Car> car = Optional.ofNullable(carRepository.findOne(id));
        return new ResponseEntity<>(car.isPresent() ? car.get() : null, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available cars", response = Iterable.class)
    @RequestMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Car>> getAll() {
        Optional<List<Car>> cars = Optional.ofNullable(carRepository.findAll());
        return new ResponseEntity<>(cars.isPresent() ? cars.get() : null, HttpStatus.OK);
    }

    @ApiOperation(value = "Create new car", response = Iterable.class)
    @RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Car> create(@NotNull @RequestBody Car car) {
        Car carCreated = carRepository.save(car);
        return new ResponseEntity<>(carCreated != null ? carCreated : null, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update existing car", response = Iterable.class)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Integer> update(@NotNull @RequestBody Car car) {
        if (car.getId() != null && carRepository.exists(car.getId())) {
            Car carUpdated = carRepository.save(car);
            return new ResponseEntity<>(carUpdated.getId(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

