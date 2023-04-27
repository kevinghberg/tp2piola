package repository;

import javax.persistence.EntityManager;

import entidades.Carrera;

public class CarreraRepository extends Repository{
    public CarreraRepository(EntityManager em) {
    	super(em);
    }

    public Carrera obtenerCarrera(int id) {
    	em.getTransaction().begin();
    	Carrera c = em.find(Carrera.class, id);
		em.getTransaction().commit();
		return c;
    }

	public void agregarCarrera(Carrera carr1) {
		em.getTransaction().begin();
		em.persist(carr1);
		em.getTransaction().commit();
	}
}
