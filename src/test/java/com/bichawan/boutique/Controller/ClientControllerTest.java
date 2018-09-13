package com.bichawan.boutique.Controller;

import com.bichawan.boutique.Entity.Address;
import com.bichawan.boutique.Entity.Client;
import com.bichawan.boutique.Service.ClientService;
import com.bichawan.boutique.VO.SearchFormVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ClientController.class, secure = false)
@DisplayName("Client Controller Test")
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Autowired
    private ObjectMapper objectMapper;

    private  Client client;

    private Address address;

    private SearchFormVO searchFormVO;

    @BeforeEach
    public void mockClient() {
        address = new Address(1, "Yamuna Vihar", "110053" , "Delhi", "Delhi");
        client = new Client(1, "Aman", "Saraf", "9940468541", "abc@gmail.com", address);
    }


    @Test
    @DisplayName("Expects To Create a Client")
    void createClient() throws Exception {

        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json(objectMapper.writeValueAsString(client)));


    }


    @Test
    @DisplayName("Expects Bad Request When Client First Name is Empty")
    void expectsBadRequestWhenFirstNameIsEmpty() throws Exception {

        client.setFirstName("");
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }


    @Test
    @DisplayName("Expects Bad Request When Client First Name is Blank")
    void expectsBadRequestWhenFirstNameIsBlank() throws Exception {

        client.setFirstName("   ");
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Expects Bad Request When Client First Name is NULL")
    void expectsBadRequestWhenFirstNameIsNull() throws Exception {

        client.setFirstName(null);
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Expects Good Request When Client Last Name is Empty")
    void expectsBadRequestWhenLastNameIsEmpty() throws Exception {

        client.setLastName("");
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Expects Good Request When Client Last Name is Null")
    void expectsGoodRequestWhenLastNameIsNull() throws Exception {

        client.setLastName(null);
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Expects Bad Request When Client Last Name is Blank")
    void expectsBadRequestWhenLastNameIsBlank() throws Exception {

        client.setLastName("   ");
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Expects Bad Request When Mobile Number Size > 10")
    void expectsBadRequestWhenMobileNumberIsGreatherThanTen() throws Exception {

        client.setMobileNumber("99404685410");
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Expects Bad Request When Mobile Number Size < 10")
    void expectsBadRequestWhenMobileNumberIsLessThanTen() throws Exception {

        client.setMobileNumber("994046854");
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }


    @Test
    @DisplayName("Expects Bad Request When Mobile Number is Blank")
    void expectsBadRequestWhenMobileNumberIsBlank() throws Exception {

        client.setMobileNumber("          ");
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Expects Bad Request When Mobile Number is Null")
    void expectsBadRequestWhenMobileNumberIsNull() throws Exception {

        client.setMobileNumber(null);
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Expects Bad Request When Mobile Number is Empty")
    void expectsBadRequestWhenMobileNumberIsEmpty() throws Exception {

        client.setMobileNumber("");
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Expects Bad Request When Mobile Number doesn't have Digits")
    void expectsBadRequestWhenMobileNumberDoesntContainsDigits() throws Exception {

        client.setMobileNumber("994046854a");
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Expects Bad Request When Client Email Is Not Email Type")
    void expectsBadRequestWhenClientEmailIsNotEmailType() throws Exception {

        client.setEmail("amansfac.ascacom");
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Expects Good Request When Street Address is Empty")
    void expectsGoodRequestWhenStreetAddressIsEmpty() throws Exception {

        Address addressNew = client.getAddress();
        addressNew.setStreetAddress("");
        client.setAddress(addressNew);
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Expects Good Request When Street Address is Blank")
    void expectsGoodRequestWhenStreetAddressIsBlank() throws Exception {

        Address addressNew = client.getAddress();
        addressNew.setStreetAddress("   ");
        client.setAddress(addressNew);
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


    @Test
    @DisplayName("Expects Good Request When Street Address is Null")
    void expectsGoodRequestWhenStreetAddressIsNull() throws Exception {

        Address addressNew = client.getAddress();
        addressNew.setStreetAddress(null);
        client.setAddress(addressNew);
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Expects Bad Request When Pin Code Contains Characters")
    void expectsBadRequestWhenPinCodeContainsCharacters() throws Exception {

        Address addressNew = client.getAddress();
        addressNew.setPinCode("aman12");
        client.setAddress(addressNew);
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Expects Bad Request When Pin Code is Empty")
    void expectsBadRequestWhenPinCodeisEmpty() throws Exception {

        Address addressNew = client.getAddress();
        addressNew.setPinCode("");
        client.setAddress(addressNew);
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }


    @Test
    @DisplayName("Expects Bad Request When Pin Code is Null")
    void expectsGoodRequestWhenPinCodeisNull() throws Exception {

        Address addressNew = client.getAddress();
        addressNew.setPinCode(null);
        client.setAddress(addressNew);
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Expects Bad Request When Pin Code is Blank")
    void expectsBadRequestWhenPinCodeisBlank() throws Exception {

        Address addressNew = client.getAddress();
        addressNew.setPinCode("      ");
        client.setAddress(addressNew);
        given(clientService.createClient(any(Client.class))).willReturn(client);

        mockMvc.perform(post("/client").content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }


    @Test
    @DisplayName("Expects To Fetch List of Clients On the basis of First Name")
    void expectsToFetchListOfClientsOnTheBasisOfFirstName() throws Exception {

        searchFormVO = new SearchFormVO("Aman", null, null);

        List<Client> clientList = new ArrayList<>();
        clientList.add(client);

        given(clientService.searchClients(any(SearchFormVO.class))).willReturn(clientList);

     //   doReturn(clientList).when(clientService).searchClients(any(SearchFormVO.class));

        String expectedString = objectMapper.writeValueAsString(clientList);

        mockMvc.perform(post("/client/searchClient").content(objectMapper.writeValueAsString(searchFormVO))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk()).andExpect(content().json(expectedString));

    }

    @Test
    @DisplayName("Expects To Fetch List of Clients On the basis of Last Name")
    void expectsToFetchListOfClientsOnTheBasisOfLastName() throws Exception {

        searchFormVO = new SearchFormVO(null, "Saraf", null);

        List<Client> clientList = new ArrayList<>();
        clientList.add(client);

        given(clientService.searchClients(any(SearchFormVO.class))).willReturn(clientList);

        //   doReturn(clientList).when(clientService).searchClients(any(SearchFormVO.class));

        String expectedString = objectMapper.writeValueAsString(clientList);

        mockMvc.perform(post("/client/searchClient").content(objectMapper.writeValueAsString(searchFormVO))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json(expectedString));

    }

    @Test
    @DisplayName("Expects To Fetch List of Clients On the basis of Mobile Number")
    void expectsToFetchListOfClientsOnTheBasisOfMobileNumber() throws Exception {

        searchFormVO = new SearchFormVO("  ", "Saraf", "9940468541");

        List<Client> clientList = new ArrayList<>();
        clientList.add(client);

        given(clientService.searchClients(any(SearchFormVO.class))).willReturn(clientList);

        //   doReturn(clientList).when(clientService).searchClients(any(SearchFormVO.class));

        String expectedString = objectMapper.writeValueAsString(clientList);

        mockMvc.perform(post("/client/searchClient").content(objectMapper.writeValueAsString(searchFormVO))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json(expectedString));

    }

}
