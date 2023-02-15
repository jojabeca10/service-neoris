package com.neoris.microservice.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neoris.microservice.persistence.crud.ClienteCrudRepository;
import com.neoris.microservice.persistence.entity.Cliente;
import com.neoris.microservice.repository.ClientRepository;

@Repository
public class ClienteRepository implements ClientRepository {
	
	@Autowired
	private ClienteCrudRepository clienteCrudRepository;

	@Override
	public Cliente save(Cliente cliente) {
		return clienteCrudRepository.save(cliente);
	}

	@Override
	public void delete(Long clientId) {
		clienteCrudRepository.deleteById(clientId);
	}

	@Override
	public Optional<Cliente> getClient(Long clientId) {
		return clienteCrudRepository.findById(clientId).map(cliente -> cliente);
	}

	@Override
	public List<Cliente> getAll() {
		return (List<Cliente>) clienteCrudRepository.findAll();
	}

}
