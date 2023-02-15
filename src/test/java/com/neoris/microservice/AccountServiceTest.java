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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import com.neoris.microservice.persistence.entity.Cliente;
import com.neoris.microservice.persistence.entity.Cuenta;
import com.neoris.microservice.repository.AccountRepository;
import com.neoris.microservice.repository.ClientRepository;
import com.neoris.microservice.service.AccountService;

public class AccountServiceTest 
{
    
	AccountService accountService;
	@Mock
    AccountRepository accountRepository;
	@Mock
	ClientRepository clientRepository;
	List<Cuenta> list;
	Cuenta cuenta;
	Cliente cliente;
	
	@BeforeEach
    void setUp() {
		accountRepository = Mockito.mock(AccountRepository.class);
		clientRepository = Mockito.mock(ClientRepository.class);
		accountService = new AccountService();
		cliente = new Cliente();
		list = new ArrayList<>();
		cuenta = new Cuenta();
		cuenta.setId(1L);
	}
	
	@AfterEach
    void tearDown() {
		accountRepository = null;
		accountService = null;
	}
	
	@Test
    void getAll() {
		ReflectionTestUtils.setField(accountService, "accountRepository", accountRepository);
		list.add(cuenta);
		when(accountRepository.getAll()).thenReturn(list);
		assertEquals(accountService.getAll().size(), 1);
    }
	
	@Test
    void save() {
		ReflectionTestUtils.setField(accountService, "clientRepository", clientRepository);
		when(clientRepository.getClient(1L)).thenReturn(Optional.ofNullable(cliente));
		assertEquals(accountService.save(new Cuenta()) , new ResponseEntity<String>("Client not found", HttpStatus.NOT_FOUND));
    }
}
