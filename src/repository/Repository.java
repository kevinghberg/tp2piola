package repository;


import javax.persistence.EntityManager;

public class Repository {
	
	protected EntityManager em = null;

	public Repository(EntityManager em) {
		this.em = em;
	}
	
	public void cerrarRepository() {
		em.close();
	}

}