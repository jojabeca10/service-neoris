package com.neoris.microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.neoris.microservice.persistence.entity.Cuenta;
import com.neoris.microservice.repository.AccountRepository;
import com.neoris.microservice.repository.ClientRepository;

@Service
public class AccountService {
	
	@Autowired
    private AccountRepository accountRepository;
	@Autowired
    private ClientRepository clientRepository;
	
	
	public List<Cuenta> getAll() {
        return accountRepository.getAll();
    }
	
	public Optional<Cuenta> getAccount(Long cuentaId) {
        return accountRepository.getAccount(cuentaId);
    }
	
	public boolean delete(Long accountId) {
        return getAccount(accountId).map(account -> {
        	accountRepository.delete(accountId);
            return true;
        }).orElse(false);
    }
	
	public ResponseEntity<String> save(Cuenta cuenta) {
		if(!clientRepository.getClient(cuenta.getIdCliente()).isEmpty()) {
			accountRepository.save(cuenta);
			return new ResponseEntity<String>("Account created", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("Client not found", HttpStatus.NOT_FOUND);
		}
			
    }

}
