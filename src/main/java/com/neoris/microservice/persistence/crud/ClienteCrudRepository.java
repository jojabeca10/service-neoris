package com.neoris.microservice.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.neoris.microservice.persistence.entity.Cliente;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Long> {

}
