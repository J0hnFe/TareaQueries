package com.example.demo.service;

import java.math.BigDecimal;

import com.example.demo.repository.modelo.Pelicula;

public interface IPeliculaService {
	
	public void agregar(Pelicula p);
	public Pelicula buscarPeliculaDinamica(String titulo, BigDecimal presupuesto, String director);
	
	public int borrarPorDirector(String director);
	public int actualizarPorTitulo(String titulo, BigDecimal recaudacion);
	
}
