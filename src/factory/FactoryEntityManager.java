package factory;

import javax.persistence.*;

import repository.CarreraRepository;
import repository.EstudianteRepository;

public class FactoryEntityManager implements Factory {
	
	private static EntityManager entityManager = null;
	private static EntityManagerFactory entityManagerFactory = null;
	private static CarreraRepository cr = null;
	private static EstudianteRepository er = null;

	public EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory != null)
			return entityManagerFactory;
		else {
			entityManagerFactory = Persistence.createEntityManagerFactory("TP2");
			return entityManagerFactory;
		}
	}


	public EntityManager getEntityManager() {
		if (entityManager != null)
			return entityManager;
		else {
			
			entityManager = getEntityManagerFactory().createEntityManager();
			return entityManager;
		}
	}


	@Override
	public EstudianteRepository getEstudianteRepository() {
		if (er != null)
			return er;
		else {
			er = new EstudianteRepository(getEntityManager());
			return er;
		}
	}


	@Override
	public CarreraRepository getCarreraRepository() {
		if (cr != null)
			return cr;
		else {
			cr = new CarreraRepository(getEntityManager());
			return cr;
		}
	}
	

}
