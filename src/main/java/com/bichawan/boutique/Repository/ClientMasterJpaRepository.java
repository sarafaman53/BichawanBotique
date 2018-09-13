package com.bichawan.boutique.Repository;

import com.bichawan.boutique.Entity.Client;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientMasterJpaRepository extends CrudRepository<Client, Integer>, JpaSpecificationExecutor<Client> {

    @Override
    List<Client> findAll(Specification<Client> specification);
}
