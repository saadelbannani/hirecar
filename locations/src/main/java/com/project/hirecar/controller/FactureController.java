package com.project.hirecar.controller;

import com.project.hirecar.model.Facture;
import com.project.hirecar.repository.FactureRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facture")
@Api(value="facture", description="Operations for locations")
public class FactureController {

    @Autowired
    private FactureRepository factureRepository;

    @RequestMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Facture>> getll() {
        Optional<List<Facture>> factures = Optional.ofNullable(factureRepository.findAll());
        return new ResponseEntity<>(factures.isPresent() ? factures.get() : null, HttpStatus.OK);
    }
}
