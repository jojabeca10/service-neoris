package com.neoris.microservice.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.neoris.microservice.persistence.crud.CuentaCrudRepository;
import com.neoris.microservice.persistence.entity.Cuenta;
import com.neoris.microservice.repository.AccountRepository;

@Repository
public class CuentaRepository implements AccountRepository {
	
	@Autowired
	private CuentaCrudRepository cuentaCrudRepository;

	@Override
	public Cuenta save(Cuenta cuenta) {
		return cuentaCrudRepository.save(cuenta);
	}

	@Override
	public List<Cuenta> getAll() {
		return (List<Cuenta>) cuentaCrudRepository.findAll();
	}

	@Override
	public void delete(Long accountId) {
		cuentaCrudRepository.deleteById(accountId);
	}

	@Override
	public Optional<Cuenta> getAccount(Long cuentaId) {
		return cuentaCrudRepository.findById(cuentaId).map(account -> account);
	}

}
