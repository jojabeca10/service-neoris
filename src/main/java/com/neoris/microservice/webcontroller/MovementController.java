package com.neoris.microservice.webcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neoris.microservice.persistence.entity.Movimiento;
import com.neoris.microservice.service.MovementService;

@RestController
@RequestMapping("/movimientos")
public class MovementController {
	
	@Autowired
	private MovementService movementService;
	
	
	@PostMapping("/save")
	public ResponseEntity<Movimiento> save(@RequestBody Movimiento movimiento) {
		return movementService.save(movimiento);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Movimiento>> getAll(){
		return new ResponseEntity<>(movementService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/reportes/{date}")
	public ResponseEntity<List<Movimiento>> getReport(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
		return new ResponseEntity<>(movementService.getReport(date), HttpStatus.OK);
	}

}
