package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
		Estudiante c = em.find(Estudiante.class, id);
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
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Estudiante> cq = cb.createQuery(Estudiante.class);
		Root<Estudiante> rootEntry = cq.from(Estudiante.class);
		CriteriaQuery<Estudiante> all = cq.select(rootEntry);
		TypedQuery<Estudiante> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}

	public List<Estudiante> buscarTodosEstudiantesOrdenado(String orden) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Estudiante> q = cb.createQuery(Estudiante.class);
		Root<Estudiante> c = q.from(Estudiante.class);
		q.select(c);
		if (orden == "ASC" || orden == "asc")
			q.orderBy(cb.asc(c.get("nombres")));
		else
			q.orderBy(cb.desc(c.get("nombres")));
		TypedQuery<Estudiante> allQuery = em.createQuery(q);
		return allQuery.getResultList();
	}

	public Estudiante buscarPorNumeroLibreta(int numLibreta) {
		Query query = em.createQuery("Select e FROM Estudiante e WHERE e.numLibreta = :numLibreta");
		query.setParameter("numLibreta", numLibreta);
		return (Estudiante) query.getSingleResult();
	}
	
	

	public List<Estudiante> buscarEstudiantePorGenero(char genero) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Estudiante> q = cb.createQuery(Estudiante.class);
		Root<Estudiante> c = q.from(Estudiante.class);
		q.select(c);
		q.where(cb.equal(c.get("genero"), genero));
		TypedQuery<Estudiante> allQuery = em.createQuery(q);
		return allQuery.getResultList();
	}

	public void borrarEstudiante(int id) {
		em.getTransaction().begin();
		Estudiante e = em.find(Estudiante.class, id);
		if (e != null)
			em.remove(e);
		em.getTransaction().commit();
	}

}