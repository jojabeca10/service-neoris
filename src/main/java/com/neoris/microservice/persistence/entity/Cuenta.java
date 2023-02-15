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
@Table(name="CUENTA")
@Getter
@Setter
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuent_sequence")
	@SequenceGenerator(name="cuent_sequence", sequenceName = "cuent_sequence", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
    private String numero;
	
	@Column(nullable = false)
    private String tipo;
	
	@Column(name = "saldo_inicial", nullable = false)
    private Double saldoInicial;
	
	@Column(nullable = false)
    private boolean estado;
	
	@Column(name="id_cliente")
	private Long idCliente;

}
