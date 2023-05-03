package repository;

import javax.persistence.EntityManager;

public class Repository {

	protected EntityManager em = null;

	public Repository(EntityManager em) {
		if (this.em == null)
			this.em = em;
	}

	public void cerrarRepository() {
		em.close();
	}

}