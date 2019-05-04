package com.project.hirecar.controller;

import com.project.hirecar.model.Client;
import com.project.hirecar.repository.ClientRepository;
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
@RequestMapping("/client")
@Api(value="clientstore", description="Operations for clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @ApiOperation(value = "View one of available clients", response = Iterable.class)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> getById(@PathVariable @NotNull Integer id) {
        Optional<Client> client = Optional.ofNullable(clientRepository.findOne(id));
        return new ResponseEntity<>(client.isPresent() ? client.get() : null, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available clients", response = Iterable.class)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getAll() {
        Optional<List<Client>> clients = Optional.ofNullable(clientRepository.findAll());
        return new ResponseEntity<>(clients.isPresent() ? clients.get() : null, HttpStatus.OK);
    }

    @ApiOperation(value = "Create a new client", response = Iterable.class)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Client> create(@NotNull @RequestBody Client client) {
        Client clientCreated = clientRepository.save(client);
        return new ResponseEntity<>(clientCreated != null ? clientCreated : null, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an existing client", response = Iterable.class)
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Integer> update(@NotNull @RequestBody Client client) {
        if (client.getId() != null && clientRepository.exists(client.getId())) {
            Client clientUpdated = clientRepository.save(client);
            return new ResponseEntity<>(clientUpdated.getId(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
