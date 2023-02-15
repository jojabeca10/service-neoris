package com.neoris.microservice.repository;

import java.util.Date;
import java.util.List;

import com.neoris.microservice.persistence.entity.Movimiento;

public interface MovementRepository {
	Movimiento save(Movimiento movimiento);
	List<Movimiento> getAll();
	List<Movimiento> getReport(Date date);
}
