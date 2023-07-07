package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPeliculaRepo;
import com.example.demo.repository.modelo.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService{

	@Autowired
	private IPeliculaRepo peliculaRepo;
	
	@Override
	public void agregar(Pelicula p) {
		this.peliculaRepo.insertar(p);
	}

	@Override
	public Pelicula buscarPeliculaDinamica(String titulo, BigDecimal presupuesto, String director) {
		return this.peliculaRepo.seleccionarPeliculaDinamica(titulo, presupuesto, director);
	}

}
