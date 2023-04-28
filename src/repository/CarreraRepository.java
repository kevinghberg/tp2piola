package repository;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entidades.Carrera;

public class CarreraRepository extends Repository {
	public CarreraRepository(EntityManager em) {
		super(em);
	}

	public Carrera obtenerCarreraPorId(int id) {
		em.getTransaction().begin();
		Carrera c = em.find(Carrera.class, id);
		em.getTransaction().commit();
		return c;
	}

	public void agregarCarrera(String nombre) {
		Carrera carrera = new Carrera();
		carrera.setNombre(nombre);
		em.getTransaction().begin();
		em.persist(carrera);
		em.getTransaction().commit();
	}

	public List<Carrera> findAll() {
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Carrera> cq = cb.createQuery(Carrera.class);
		Root<Carrera> rootEntry = cq.from(Carrera.class);
		CriteriaQuery<Carrera> all = cq.select(rootEntry);
		TypedQuery<Carrera> allQuery = em.createQuery(all);
		em.getTransaction().commit();
		return allQuery.getResultList();
	}

	public void borrarCarrera(int id) {
		this.getClass();
		em.getTransaction().begin();
		Carrera c = em.find(Carrera.class, id);
		if (c != null)
			em.remove(c);
		em.getTransaction().commit();
	}

	public Carrera obtenerCarreraPorNombre(final String nombre) {
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Carrera> cq = cb.createQuery(Carrera.class);
		Root<Carrera> root = cq.from(Carrera.class);
		cq.select(root);
		cq.where(cb.equal(root.as(Carrera.class), nombre));
		TypedQuery<Carrera> typed = em.createQuery(cq);
		try {
			return typed.getSingleResult();
		} catch (final NoResultException nre) {
			return null;
		}
	}

}
