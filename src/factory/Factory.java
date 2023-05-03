package factory;

import javax.persistence.*;

import repository.CarreraRepository;
import repository.Carrera_Estudiante_Repository;
import repository.EstudianteRepository;

public interface Factory {

	public EntityManagerFactory getEntityManagerFactory();
	
	public EntityManager getEntityManager();
	
	public EstudianteRepository getEstudianteRepository();
	
	public CarreraRepository getCarreraRepository();

	public Carrera_Estudiante_Repository getCarreraEstudianteRepository();

}
