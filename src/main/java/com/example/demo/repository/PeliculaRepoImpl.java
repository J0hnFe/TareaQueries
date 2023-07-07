package com.example.demo.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Pelicula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PeliculaRepoImpl implements IPeliculaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Pelicula p) {
		this.entityManager.persist(p);
	}

	@Override
	public Pelicula seleccionarPeliculaDinamica(String titulo, BigDecimal presupuesto, String director) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Pelicula> criteriaQuery = builder.createQuery(Pelicula.class);
		Root<Pelicula> myTablaFrom = criteriaQuery.from(Pelicula.class); 
		Predicate pTitulo = builder.equal(myTablaFrom.get("titulo"), titulo);
		Predicate pDirector = builder.equal(myTablaFrom.get("director"), director);
		Predicate predicadoFinal=null;
		
		//<= 300 buscar por titulo o director else buscar por titulo y autor
		if(presupuesto.compareTo(new BigDecimal(300))<=0) {	//Presupuesto en millones
			
			predicadoFinal = builder.or(pTitulo, pDirector);
			
		}else {
			
			predicadoFinal=builder.and(pTitulo,pDirector);
			
		}
		
		criteriaQuery.select(myTablaFrom).where(predicadoFinal);
		TypedQuery<Pelicula> queryFinal = this.entityManager.createQuery(criteriaQuery);
		return queryFinal.getSingleResult();
	}
}
