package com.project.hirecar.controller;

import com.project.hirecar.model.Facture;
import com.project.hirecar.repository.FactureRepository;
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
@RequestMapping("/factures")
@Api(value="facture")
public class FactureController {

    @Autowired
    private FactureRepository factureRepository;

    @ApiOperation(value = "View a list of available factures", response = Iterable.class)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity<List<Facture>> getAll() {
        Optional<List<Facture>> factures = Optional.ofNullable(factureRepository.findAll());
        return new ResponseEntity<>(factures.orElse(null), HttpStatus.OK);
    }

    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<Facture> getById(@PathVariable @NotNull Integer id) {
        Optional<Facture> facture = factureRepository.findById(id);
        return new ResponseEntity<>(facture.orElse(null), HttpStatus.OK);
    }

    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Facture> create(@NotNull @RequestBody Facture facture) {
        Facture factureCreated = factureRepository.save(facture);
        return new ResponseEntity<>(factureCreated, HttpStatus.CREATED);
    }

    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Facture> update(@NotNull @RequestBody Facture facture) {
        if(facture.getId() != null && factureRepository.existsById(facture.getId())) {
            Facture factureUpdated = factureRepository.save(facture);
            return new ResponseEntity<>(factureUpdated, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
