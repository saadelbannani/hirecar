package com.project.hirecar.controller;

import com.project.hirecar.model.Client;
import com.project.hirecar.repository.ClientRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@Api(value="clientstore", description="Operations for clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Client> getById(@PathVariable @NotNull Integer id) {
        Optional<Client> client = Optional.ofNullable(clientRepository.findOne(id));
        return new ResponseEntity<>(client.isPresent() ? client.get() : null, HttpStatus.OK);
    }

    @RequestMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getll() {
        Optional<List<Client>> clients = Optional.ofNullable(clientRepository.findAll());
        return new ResponseEntity<>(clients.isPresent() ? clients.get() : null, HttpStatus.OK);
    }
}
