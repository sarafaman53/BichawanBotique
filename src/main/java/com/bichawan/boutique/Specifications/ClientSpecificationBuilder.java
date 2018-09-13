package com.bichawan.boutique.Specifications;

import com.bichawan.boutique.Entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ClientSpecificationBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientSpecificationBuilder.class);

    private List<SearchCriteria> searchCriteriaList;

    public ClientSpecificationBuilder() {
        this.searchCriteriaList = new ArrayList<>();
    }

    public ClientSpecificationBuilder with (String key, String operation, String value) {
        searchCriteriaList.add(new SearchCriteria(key, operation, value));
        LOGGER.info("Search Criteria Added to Builder List");
        return  this;
    }

    public Specification<Client> build() {

        LOGGER.info("Inside Clinet Specifiction Builder build");
        if (searchCriteriaList.isEmpty()) {
            return  null;
        }

        List<Specification<Client>> clientSpecificationList = new ArrayList<>();

        for (SearchCriteria searchCriteria : searchCriteriaList) {
            clientSpecificationList.add(new ClientSearchSpecification(searchCriteria));
        }

        Specification<Client> result = clientSpecificationList.get(0);
        for (int i=1; i< clientSpecificationList.size();i++) {
            result = Specification.where(result).and(clientSpecificationList.get(i));
        }

        LOGGER.info("Client Search Criterion SuccessFully created");

        return result;
    }

}
