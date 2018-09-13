package com.bichawan.boutique.ServiceImpl;

import com.bichawan.boutique.Entity.Address;
import com.bichawan.boutique.Entity.Client;
import com.bichawan.boutique.Repository.ClientMasterJpaRepository;
import com.bichawan.boutique.VO.SearchFormVO;
import name.falgout.jeffrey.testing.junit.mockito.MockitoExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;


@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@DisplayName("Client Service Test")
class ClientServiceImplTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientMasterJpaRepository clientMasterJpaRepository;

    private Address address;

    @Test
    @DisplayName("Expects to save the client to Repository")
    void testCreateClient() {

        address = new Address(1, "Yamuna Vihar", "110053" , "Delhi", "Delhi");

        Client client = new Client(1, "Aman", "Saraf", "9940468541", "amans@facasca.com", address);
        given(clientMasterJpaRepository.save(any(Client.class))).willReturn(client);
        Client returnedClient = clientService.createClient(client);
        assertEquals(client, returnedClient);

    }


    @Test
    @DisplayName("Expects to Return List Of Clients from Repository")
    void testSearchClients() {

        address = new Address(1, "Yamuna Vihar", "110053" , "Delhi", "Delhi");

        Client client = new Client(1, "Aman", "Saraf", "9940468541", "amans@facasca.com", address);

        SearchFormVO searchFormVO = new SearchFormVO();
        searchFormVO.setFirstName("Aman");
        searchFormVO.setLastName("Saraf");
        searchFormVO.setMobileNumber("9940468541");

        List<Client> clientList = new ArrayList<>();
        clientList.add(client);

        given(clientMasterJpaRepository.findAll(any(Specification.class))).willReturn(clientList);

        List<Client> returnedClientList = clientService.searchClients(searchFormVO);
        assertEquals(clientList, returnedClientList);

    }

    @Test
    @DisplayName("Expects to Return Empty List Of Clients from Repository When First Name is Empty")
    void testSearchClientsWhenFirstNameIsEmpty() {

        address = new Address(1, "Yamuna Vihar", "110053" , "Delhi", "Delhi");

        Client client = new Client(1, "Aman", "Saraf", "9940468541", "amans@facasca.com", address);

        SearchFormVO searchFormVO = new SearchFormVO();
        searchFormVO.setFirstName("");

        List<Client> clientList = new ArrayList<>();
        clientList.add(client);

        given(clientMasterJpaRepository.findAll(any(Specification.class))).willReturn(clientList);

        List<Client> returnedClientList = clientService.searchClients(searchFormVO);
        assertEquals(new ArrayList<>(), returnedClientList);

    }



    @Test
    @DisplayName("Expects to Return Empty List Of Clients from Repository When First Name is NULL")
    void testSearchClientsWhenFirstNameIsNull() {

        address = new Address(1, "Yamuna Vihar", "110053" , "Delhi", "Delhi");

        Client client = new Client(1, "Aman", "Saraf", "9940468541", "amans@facasca.com", address);

        SearchFormVO searchFormVO = new SearchFormVO();
        searchFormVO.setFirstName(null);

        List<Client> clientList = new ArrayList<>();
        clientList.add(client);

        given(clientMasterJpaRepository.findAll(any(Specification.class))).willReturn(clientList);

        List<Client> returnedClientList = clientService.searchClients(searchFormVO);
        assertEquals(new ArrayList<>(), returnedClientList);

    }

    @Test
    @DisplayName("Expects to Return List Of Clients from Repository When Last Name is Given")
    void testSearchClientsWhenLastNameIsGiven() {

        address = new Address(1, "Yamuna Vihar", "110053" , "Delhi", "Delhi");

        Client client = new Client(1, "Aman", "Saraf", "9940468541", "amans@facasca.com", address);

        SearchFormVO searchFormVO = new SearchFormVO();
        searchFormVO.setLastName("Saraf");

        List<Client> clientList = new ArrayList<>();
        clientList.add(client);

        given(clientMasterJpaRepository.findAll(any(Specification.class))).willReturn(clientList);

        List<Client> returnedClientList = clientService.searchClients(searchFormVO);
        assertEquals(clientList, returnedClientList);

    }

    @Test
    @DisplayName("Expects to Return List Of Clients from Repository When Mobile Number is Given")
    void testSearchClientsWhenMobileNumberIsGiven() {

        address = new Address(1, "Yamuna Vihar", "110053" , "Delhi", "Delhi");

        Client client = new Client(1, "Aman", "Saraf", "9940468541", "amans@facasca.com", address);

        SearchFormVO searchFormVO = new SearchFormVO();
        searchFormVO.setMobileNumber("9940468541");

        List<Client> clientList = new ArrayList<>();
        clientList.add(client);

        given(clientMasterJpaRepository.findAll(any(Specification.class))).willReturn(clientList);

        List<Client> returnedClientList = clientService.searchClients(searchFormVO);
        assertEquals(clientList, returnedClientList);

    }
}
