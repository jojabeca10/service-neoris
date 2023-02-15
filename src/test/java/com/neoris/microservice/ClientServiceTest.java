package com.neoris.microservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import com.neoris.microservice.persistence.entity.Cliente;
import com.neoris.microservice.repository.ClientRepository;
import com.neoris.microservice.service.ClientService;

public class ClientServiceTest 
{
    
	ClientService clientService;
	@Mock
	ClientRepository clientRepository;
	List<Cliente> list;
	Cliente cliente;
	
	@BeforeEach
    void setUp() {
		clientRepository = Mockito.mock(ClientRepository.class);
		clientService = new ClientService();
		list = new ArrayList<>();
		cliente = new Cliente();
		cliente.setId(1L);
	}
	
	@AfterEach
    void tearDown() {
		clientRepository = null;
		clientService = null;
	}
	
	@Test
    void getAll() {
		ReflectionTestUtils.setField(clientService, "clientRepository", clientRepository);
		list.add(cliente);
		when(clientRepository.getAll()).thenReturn(list);
		assertEquals(clientService.getAll().size(), 1);
    }
	
	@Test
    void getClient() {
		ReflectionTestUtils.setField(clientService, "clientRepository", clientRepository);
		when(clientRepository.getClient(1L)).thenReturn(Optional.ofNullable(cliente));
		assertEquals(clientService.getClient(1L).isPresent(), true);
    }
}
