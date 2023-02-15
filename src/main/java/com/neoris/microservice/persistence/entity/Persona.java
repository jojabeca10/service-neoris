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
import lombok.ToString;

@Entity
@Table(name = "PERSONA")
@ToString
@Getter
@Setter
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_sequence")
	@SequenceGenerator(name="pers_sequence", sequenceName = "pers_sequence", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
    private String nombre;
	
	@Column(nullable = false)
    private char genero;
	
	@Column(nullable = false)
    private int edad;
	
	@Column(nullable = false)
    private Long identificacion;
	
	@Column(nullable = false)
    private String direccion;
	
	@Column(nullable = false)
    private String telefono;
}
