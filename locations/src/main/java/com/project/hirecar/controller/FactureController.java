package com.project.hirecar.controller;

import com.project.hirecar.model.Facture;
import com.project.hirecar.repository.FactureRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facture")
@Api(value="facture", description="Operations for locations")
public class FactureController {

    @Autowired
    private FactureRepository factureRepository;

    @ApiOperation(value = "View a list of available factures", response = Iterable.class)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity<List<Facture>> getAll() {
        Optional<List<Facture>> factures = Optional.ofNullable(factureRepository.findAll());
        return new ResponseEntity<>(factures.isPresent() ? factures.get() : null, HttpStatus.OK);
    }

    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<Facture> getById(@PathVariable @NotNull Integer id) {
        Optional<Facture> facture = Optional.ofNullable(factureRepository.findOne(id));
        return new ResponseEntity<>(facture.isPresent() ? facture.get() : null, HttpStatus.OK);
    }
}
