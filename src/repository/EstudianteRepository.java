package repository;

import javax.persistence.EntityManager;

public class EstudianteRepository extends Repository {
	
    public EstudianteRepository(EntityManager em) {
    	super(em);
    }
	
}