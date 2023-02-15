package com.neoris.microservice.persistence.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.neoris.microservice.persistence.entity.Movimiento;

public interface MovimientoCrudRepository extends CrudRepository<Movimiento, Long> {

	List<Movimiento> findAllByFechaBetween(
		      Date publicationTimeStart,
		      Date publicationTimeEnd);

}
