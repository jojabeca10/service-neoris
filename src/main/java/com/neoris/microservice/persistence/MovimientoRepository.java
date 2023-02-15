package com.neoris.microservice.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neoris.microservice.persistence.crud.MovimientoCrudRepository;
import com.neoris.microservice.persistence.entity.Movimiento;
import com.neoris.microservice.repository.MovementRepository;

@Repository
public class MovimientoRepository implements MovementRepository {
	
	@Autowired
	private MovimientoCrudRepository movimientoCrudRepository;

	@Override
	public Movimiento save(Movimiento movimiento) {
		return movimientoCrudRepository.save(movimiento);
	}

	@Override
	public List<Movimiento> getAll() {
		return (List<Movimiento>) movimientoCrudRepository.findAll();
	}

	@Override
	public List<Movimiento> getReport(Date date) {
		return (List<Movimiento>) movimientoCrudRepository.findAllByFechaBetween(date, new Date());
	}

}
