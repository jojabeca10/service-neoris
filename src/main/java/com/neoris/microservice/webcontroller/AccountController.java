package com.neoris.microservice.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neoris.microservice.persistence.entity.Cuenta;
import com.neoris.microservice.service.AccountService;

@RestController
@RequestMapping("/cuentas")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Cuenta>> getAll(){
		return new ResponseEntity<>(accountService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Cuenta cuenta) {
		return accountService.save(cuenta);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity  delete(@PathVariable("id") Long cuentaId) {
		if(accountService.delete(cuentaId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
