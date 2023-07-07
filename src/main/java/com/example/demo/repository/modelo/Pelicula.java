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
	@GeneratedValue(generator = "seq_peli", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_peli", sequenceName = "seq_peli", allocationSize = 1)
	@Column(name = "peli_id")
	private Integer id;
	@Column(name = "peli_titulo")
	private String titulo;
	@Column(name = "peli_presupuesto")
	private BigDecimal presupuesto;
	@Column(name = "peli_director")
	private String director;
	@Column(name = "peli_fecha_lanzamiento")
	private LocalDate fechaLanzamiento;
	@Column(name = "peli_recaudacion")
	private BigDecimal recaudacion;
	
	//Getters y Setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public BigDecimal getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(BigDecimal presupuesto) {
		this.presupuesto = presupuesto;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public BigDecimal getRecaudacion() {
		return recaudacion;
	}
	public void setRecaudacion(BigDecimal recaudacion) {
		this.recaudacion = recaudacion;
	}
	public Integer getId() {
		return id;
	}
	
	//toString
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", presupuesto=" + presupuesto + ", director=" + director
				+ ", fechaLanzamiento=" + fechaLanzamiento + ", recaudacion=" + recaudacion + "]";
	}
}
