package com.neoris.microservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.neoris.microservice.persistence.entity.Cuenta;
import com.neoris.microservice.persistence.entity.Movimiento;
import com.neoris.microservice.repository.AccountRepository;
import com.neoris.microservice.repository.MovementRepository;

@Service
public class MovementService {
	
	@Autowired
    private MovementRepository movementRepository;
	@Autowired
    private AccountRepository accountRepository;
	
	
	public Optional<Cuenta> getAccount(Long cuentaId) {
        return accountRepository.getAccount(cuentaId);
    }
	
	public ResponseEntity<Movimiento> save(Movimiento movimiento) {
		accountRepository.getAccount(movimiento.getNumCuenta()).map(account -> {
			if(account.getSaldoInicial() == 0 && movimiento.getMovimiento() > 0)
				return new ResponseEntity<String>("Saldo no disponible", HttpStatus.CREATED);
			
			double saldoInicial = account.getSaldoInicial();
			movimiento.setSaldoInicial(saldoInicial);
			movimiento.setSaldoDisponible(saldoInicial + movimiento.getMovimiento());
			movimiento.setTipo(account.getTipo());
			movementRepository.save(movimiento);
			return new ResponseEntity<Movimiento>(movimiento, HttpStatus.CREATED);
        });
		return new ResponseEntity<Movimiento>(movimiento, HttpStatus.NOT_FOUND);
    }
	
	public List<Movimiento> getAll() {
        return movementRepository.getAll();
    }
	
	public List<Movimiento> getReport(Date date) {
        return movementRepository.getReport(date);
    }

}
