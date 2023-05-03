package repository;

import java.util.Comparator;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import dto.CarreraInscriptosDTO;
import dto.ReporteDTO;
import entidades.Carrera;
import entidades.Estudiante;

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
		em.getTransaction().begin();
		Carrera c = em.find(Carrera.class, id);
		if (c != null)
			em.remove(c);
		em.getTransaction().commit();
	}
	
	
	public List<CarreraInscriptosDTO> buscarCarrerasConEstudiantesOrdenadoPorCantidad(){
		Query query = em.createQuery("SELECT NEW dto.CarreraInscriptosDTO(cc.nombre, ( "
				+ "  SELECT COUNT(e.idEstudiante) "
				+ "  FROM Carrera_Estudiante ce "
				+ "  JOIN ce.estudiante e "
				+ "  WHERE ce.carrera.idCarrera = cc.idCarrera)) "
				+ "FROM Carrera cc ");
		List<CarreraInscriptosDTO> dtos =  query.getResultList();
		dtos.sort(Comparator.comparing(CarreraInscriptosDTO::getCantidadInscriptos));
		return dtos;
	}
	
	public List<ReporteDTO> buscarCarrerasConReporteDTO(){
		//TODO NO FUNCIONA
		Query query = em.createQuery("SELECT NEW dto.ReporteDTO(cc.nombre, ce2.fechaIngreso, ( "
				+ " SELECT COUNT(e.idEstudiante) "
				+ " FROM Carrera_Estudiante ce "
				+ " JOIN ce.estudiante e "
				+ " WHERE ce.graduado = false "
				+ " AND ce.carrera = cc "
				+ " AND ce.fechaIngreso = ce.fechaIngreso)) "
				+ " FROM Carrera cc "
				+ " JOIN Carrera_Estudiante ce2 "
				+ " WHERE ce2.graduado = false "
				+ " GROUP BY cc.nombre, ce2.fechaIngreso ");
		List<ReporteDTO> dtos =  query.getResultList();
		return dtos;
	}

}
