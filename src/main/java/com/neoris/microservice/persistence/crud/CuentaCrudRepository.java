package com.neoris.microservice.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.neoris.microservice.persistence.entity.Cuenta;

public interface CuentaCrudRepository extends CrudRepository<Cuenta, Long> {

}
