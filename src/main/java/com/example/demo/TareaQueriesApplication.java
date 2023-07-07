package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Pelicula;
import com.example.demo.service.IPeliculaService;

@SpringBootApplication
public class TareaQueriesApplication implements CommandLineRunner{

	@Autowired
	private IPeliculaService peliculaService;
	
	public static void main(String[] args) {
		SpringApplication.run(TareaQueriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LocalDate dateAvatar = LocalDate.of(2009, 12, 17);
		LocalDate dateTitanic = LocalDate.of(1997, 12, 19);
		LocalDate dateTransformers = LocalDate.of(2007, 7, 20);
		LocalDate dateInterestellar = LocalDate.of(2014, 10, 26);
		LocalDate dateDjango = LocalDate.of(2013, 1, 18);
		LocalDate datePulp = LocalDate.of(1994, 10, 14);
		
		Pelicula pelicula1 = new Pelicula();
		pelicula1.setTitulo("Avatar");
		pelicula1.setRecaudacion(new BigDecimal(2500));
		pelicula1.setPresupuesto(new BigDecimal(230));
		pelicula1.setFechaLanzamiento(dateAvatar);
		pelicula1.setDirector("James Cameron");
		
		Pelicula pelicula2 = new Pelicula();
		pelicula2.setTitulo("Titanic");
		pelicula2.setRecaudacion(new BigDecimal(2257));
		pelicula2.setPresupuesto(new BigDecimal(200));
		pelicula2.setFechaLanzamiento(dateTitanic);
		pelicula2.setDirector("James Cameron");
		
		Pelicula pelicula3 = new Pelicula();
		pelicula3.setTitulo("Transformers");
		pelicula3.setRecaudacion(new BigDecimal(709.7));
		pelicula3.setPresupuesto(new BigDecimal(147));
		pelicula3.setFechaLanzamiento(dateTransformers);
		pelicula3.setDirector("Michael Bay");
		
		Pelicula pelicula4 = new Pelicula();
		pelicula4.setTitulo("Interestellar");
		pelicula4.setRecaudacion(new BigDecimal(701.7));
		pelicula4.setPresupuesto(new BigDecimal(165));
		pelicula4.setFechaLanzamiento(dateInterestellar);
		pelicula4.setDirector("Christopher Nolan");
		
		Pelicula pelicula5 = new Pelicula();
		pelicula5.setTitulo("Django");
		pelicula5.setRecaudacion(new BigDecimal(426));
		pelicula5.setPresupuesto(new BigDecimal(100));
		pelicula5.setFechaLanzamiento(dateDjango);
		pelicula5.setDirector("Quentin Tarantino");
		
		Pelicula pelicula6 = new Pelicula();
		pelicula6.setTitulo("Pulp Fiction");
		pelicula6.setRecaudacion(new BigDecimal(213.9));
		pelicula6.setPresupuesto(new BigDecimal(8.5));
		pelicula6.setFechaLanzamiento(datePulp);
		pelicula6.setDirector("Quentin Tarantino");
		
//		this.peliculaService.agregar(pelicula1);
//		this.peliculaService.agregar(pelicula2);
//		this.peliculaService.agregar(pelicula3);
//		this.peliculaService.agregar(pelicula4);
//		this.peliculaService.agregar(pelicula5);
//		this.peliculaService.agregar(pelicula6);
		
		Pelicula pAux = this.peliculaService.buscarPeliculaDinamica("Transformers", new BigDecimal(200), "Michael Bay");
		System.out.println(pAux);
		
		Integer intAux = this.peliculaService.actualizarPorTitulo("Avatar", new BigDecimal(2684));
		System.out.println(intAux);
		
		Integer intAux2 = this.peliculaService.borrarPorDirector("Quentin Tarantino");
		System.out.println(intAux2);
	}
}
