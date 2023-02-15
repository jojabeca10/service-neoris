package com.neoris.microservice.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CLIENTE")
@Getter
@Setter
public class Cliente extends Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_sequence")
	@SequenceGenerator(name="clie_sequence", sequenceName = "clie_sequence", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
    private String contrasena;
	
	@Column(nullable = false)
    private boolean estado;

}
