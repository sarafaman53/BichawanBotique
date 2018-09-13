package com.bichawan.boutique.Specifications;

import com.bichawan.boutique.Entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ClientSearchSpecification implements Specification<Client> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientSearchSpecification.class);

    private SearchCriteria searchCriteria;

    public ClientSearchSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        LOGGER.debug("Inside toPredicate() of Client Search Specification");
        if (searchCriteria.getOperation().equals(":")) {
            return criteriaBuilder.like(root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
        }

        return null;
    }
}
