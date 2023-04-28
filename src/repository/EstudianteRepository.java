package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entidades.Estudiante;

public class EstudianteRepository extends Repository {

	public EstudianteRepository(EntityManager em) {
		super(em);
	}

	public Estudiante obtenerEstudiantePorId(int id) {
		em.getTransaction().begin();
		Estudiante c = em.find(Estudiante.class, id);
		em.getTransaction().commit();
		return c;
	}

	public void agregarEstudiante(String nombres, String apellido, int edad, char genero, int numeroDoc,
			String ciudadResidencia, int numLibreta) {
		Estudiante e = new Estudiante();
		e.setNombres(nombres);
		e.setApellido(apellido);
		e.setEdad(edad);
		e.setGenero(genero);
		e.setNumeroDoc(numeroDoc);
		e.setCiudadResidencia(ciudadResidencia);
		e.setNumLibreta(numLibreta);
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}

	public List<Estudiante> findAll() {
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Estudiante> cq = cb.createQuery(Estudiante.class);
		Root<Estudiante> rootEntry = cq.from(Estudiante.class);
		CriteriaQuery<Estudiante> all = cq.select(rootEntry);
		TypedQuery<Estudiante> allQuery = em.createQuery(all);
		em.getTransaction().commit();
		return allQuery.getResultList();
	}
	
	public void borrarEstudiante(int id) {
		em.getTransaction().begin();
		Estudiante e = em.find(Estudiante.class, id);
		em.remove(e);
		em.getTransaction().commit();
	}

}