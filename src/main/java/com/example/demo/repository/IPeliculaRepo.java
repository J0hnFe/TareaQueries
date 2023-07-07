package com.example.demo.repository;

import java.math.BigDecimal;

import com.example.demo.repository.modelo.Pelicula;

public interface IPeliculaRepo {

	public void insertar(Pelicula p);
	public Pelicula seleccionarPeliculaDinamica(String titulo, BigDecimal presupuesto, String director);
	
	
}
