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

import com.neoris.microservice.persistence.entity.Cliente;
import com.neoris.microservice.service.ClientService;

@RestController
@RequestMapping("/clientes")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	@PostMapping("/save")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clientService.save(cliente), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity  delete(@PathVariable("id") Long clientId) {
		if(clientService.delete(clientId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Cliente>> getAll(){
		return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
	}

}
