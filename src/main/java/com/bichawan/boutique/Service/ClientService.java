package com.bichawan.boutique.Service;

import com.bichawan.boutique.Entity.Client;
import com.bichawan.boutique.VO.SearchFormVO;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);

    List<Client> searchClients(SearchFormVO searchFormVO);
}
