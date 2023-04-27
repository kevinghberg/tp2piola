package factory;

import javax.persistence.*;

import repository.CarreraRepository;
import repository.EstudianteRepository;

public interface Factory {

	public EntityManagerFactory getEntityManagerFactory();
	
	public EntityManager getEntityManager();
	
	public EstudianteRepository getEstudianteRepository();
	
	public CarreraRepository getCarreraRepository();

}
