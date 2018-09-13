package com.bichawan.boutique.Integration;


import com.bichawan.boutique.Entity.Address;
import com.bichawan.boutique.Entity.Client;
import com.bichawan.boutique.Repository.ClientMasterJpaRepository;
import com.bichawan.boutique.Service.ClientService;
import com.bichawan.boutique.VO.SearchFormVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientMasterJpaRepository clientMasterJpaRepository;

    @Test
    @Transactional
    @DisplayName("Expects to persist the client into Repository")
    public void createClient() {

        Address address = new Address(1, "Yamuna Vihar", "110053" , "Delhi", "Delhi");

        Client client = new Client(1, "Aman", "Saraf", "9940468541", "amans@faca.scacom", address);
        Client returnedClient = clientService.createClient(client);
        assertEquals(client, returnedClient);

    }

    @Test
    @Transactional
    @DisplayName("Expects to Fetch List of Clients From the Repository")
    public void expectsToReturnListOfClientsWhenSearchIsValid() {

        Address address = new Address(1, "Yamuna Vihar", "110053" , "Delhi", "Delhi");

        Client client = new Client(1, "Aman", "Saraf", "9940468541", "amans@faca.scacom", address);

        List<Client> expectedClientList = new ArrayList<>();
        expectedClientList.add(client);

        SearchFormVO searchFormVO = new SearchFormVO();
        searchFormVO.setFirstName("Ama");
        searchFormVO.setLastName(null);
        searchFormVO.setMobileNumber("404");

        List<Client> returnedClientList = clientService.searchClients(searchFormVO);

        assertEquals(expectedClientList, returnedClientList);

    }

}
