package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.CollectionId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue(generator = "seq_pelicula", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_pelicula", sequenceName = "seq_pelicula", allocationSize = 1)
	@Column(name = "peli_tituo}lo")
	private String titulo;
	private BigDecimal presupuesto;
	private String director;
	private LocalDate fechaLanzamiento;
	private BigDecimal recaudacion;

}
