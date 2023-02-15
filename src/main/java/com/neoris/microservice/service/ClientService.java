package com.neoris.microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.microservice.persistence.entity.Cliente;
import com.neoris.microservice.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
    private ClientRepository clientRepository;
	
	public Cliente save(Cliente cliente) {
        return clientRepository.save(cliente);
    }
	
	public Optional<Cliente> getClient(Long clientId) {
        return clientRepository.getClient(clientId);
    }
	
	public boolean delete(Long clientId) {
        return getClient(clientId).map(client -> {
        	clientRepository.delete(clientId);
            return true;
        }).orElse(false);
    }
	
	public List<Cliente> getAll() {
        return clientRepository.getAll();
    }
}
