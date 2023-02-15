package com.neoris.microservice.repository;

import java.util.List;
import java.util.Optional;

import com.neoris.microservice.persistence.entity.Cliente;

public interface ClientRepository {
	Optional<Cliente> getClient(Long clientId);
	Cliente save(Cliente cliente);
	void delete(Long clientId);
	List<Cliente> getAll();
}
