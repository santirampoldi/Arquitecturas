package dao;


import javax.persistence.EntityManager;

import entidades.EMF;
import entidades.Trabajo;    

public class TrabajoDAO extends BaseJpaDAO<Trabajo, Integer> {

	private static TrabajoDAO trabajoDao;

	private TrabajoDAO(){
		super(Trabajo.class,Integer.class);
	}

	public static TrabajoDAO getInstance() {
		if(trabajoDao == null)
			trabajoDao = new TrabajoDAO();
		return trabajoDao;
	}

	@Override
	public Trabajo findById(Integer id) {
		EntityManager entityManager = EMF.createEntityManager();
		Trabajo trabajo = entityManager.find(Trabajo.class, id);
		entityManager.close();
		return trabajo;
	}

	public Trabajo persist(Trabajo trabajo) {
		EntityManager entityManager = EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(trabajo);
		entityManager.getTransaction().commit();
		entityManager.close();
		return trabajo;
	}

//	@Override
//	public List findAll() {
//		throw new UnsupportedOperationException();
//	}

}
