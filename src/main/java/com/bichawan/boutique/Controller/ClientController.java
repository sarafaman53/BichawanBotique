package com.bichawan.boutique.Controller;


import com.bichawan.boutique.Entity.Client;
import com.bichawan.boutique.Service.ClientService;
import com.bichawan.boutique.VO.SearchFormVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);


    @Autowired
    ClientService clientService;


    @CrossOrigin
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<Client> createClient(@RequestBody @Valid Client client) {

        LOGGER.debug("Inside Create Client");

       return new ResponseEntity<>(clientService.createClient(client), HttpStatus.OK);

    }

    @CrossOrigin
    @PostMapping(value = "/searchClient" , consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> searchClients(@RequestBody @Valid SearchFormVO searchFormVO) {

        LOGGER.debug("Inside Search Clients");

        return new ResponseEntity<>(clientService.searchClients(searchFormVO), HttpStatus.OK);

    }
}
