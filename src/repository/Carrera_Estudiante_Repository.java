package repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import entidades.Carrera;
import entidades.Estudiante;
import entidades.Carrera_Estudiante;

public class Carrera_Estudiante_Repository extends Repository{

	public Carrera_Estudiante_Repository(EntityManager em) {
		super(em);
	}
	
	public void agregarRelacionEstudianteCarrera(Carrera carrera, Estudiante estudiante, boolean graduado, LocalDate fecha_ingreso) {
		Carrera_Estudiante ce = new Carrera_Estudiante();
		ce.setCarrera(carrera);
		ce.setEstudiante(estudiante);
		ce.setGraduado(graduado);
		ce.setAntiguedad(fecha_ingreso);
		em.getTransaction().begin();
		em.persist(ce);
		em.getTransaction().commit();
	}

}
