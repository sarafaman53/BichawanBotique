package com.bichawan.boutique.ServiceImpl;

import com.bichawan.boutique.Entity.Client;
import com.bichawan.boutique.Repository.ClientMasterJpaRepository;
import com.bichawan.boutique.Service.ClientService;
import com.bichawan.boutique.Specifications.ClientSpecificationBuilder;
import com.bichawan.boutique.VO.SearchFormVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    ClientMasterJpaRepository clientMasterJpaRepository;

    @Override
    public Client createClient(Client client) {

        LOGGER.info("Inside Create Client Service");

        LOGGER.debug("Client Record Entered is " , client.toString());

       return clientMasterJpaRepository.save(client);

    }

    @Override
    public List<Client> searchClients(SearchFormVO searchFormVO) {

        LOGGER.info("Inside Search Clients Service");

        LOGGER.debug("Search Request is : " , searchFormVO.toString());

        ClientSpecificationBuilder clientSearchSpecificationBuilder = new ClientSpecificationBuilder();

        if (!(StringUtils.isBlank(searchFormVO.getFirstName()))) {
            clientSearchSpecificationBuilder.with("firstName", ":", searchFormVO.getFirstName().trim());
        }

        if (!(StringUtils.isBlank(searchFormVO.getLastName()))) {
            clientSearchSpecificationBuilder.with("lastName", ":", searchFormVO.getLastName().trim());
        }

        if (!(StringUtils.isBlank(searchFormVO.getMobileNumber()))) {
            clientSearchSpecificationBuilder.with("mobileNumber", ":", searchFormVO.getMobileNumber().trim());
        }

        Specification<Client> clientSearchSpecification = clientSearchSpecificationBuilder.build();

        LOGGER.info("Client Search Specification Successfully built");

        return clientMasterJpaRepository.findAll(clientSearchSpecification);
    }
}
