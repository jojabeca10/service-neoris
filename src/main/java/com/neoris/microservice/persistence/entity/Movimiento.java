package com.neoris.microservice.persistence.entity;

import java.util.Date;

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
@Table(name = "MOVIMIENTO")
@ToString
@Getter
@Setter
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mov_sequence")
	@SequenceGenerator(name="mov_sequence", sequenceName = "mov_sequence", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
    private Date fecha;
	
	@Column(nullable = false)
    private String tipo;
	
	@Column(name="saldo_inicial")
    private Double saldoInicial;
	
	@Column(name="saldo_disponible")
    private Double saldoDisponible;
	
	@Column(nullable = false)
    private Double movimiento;
	
	@Column(name = "num_cuenta", nullable = false)
	private Long numCuenta;

}
