package com.neoris.microservice.repository;

import java.util.List;
import java.util.Optional;
import com.neoris.microservice.persistence.entity.Cuenta;

public interface AccountRepository {
	Optional<Cuenta> getAccount(Long cuentaId);
	Cuenta save(Cuenta cuenta);
	List<Cuenta> getAll();
	void delete(Long accountId);
}
