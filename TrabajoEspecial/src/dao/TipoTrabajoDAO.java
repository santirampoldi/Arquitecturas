package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entidades.EMF;
import entidades.TipoTrabajo;    

public class TipoTrabajoDAO extends BaseJpaDAO<TipoTrabajo, Integer> {

	private static TipoTrabajoDAO tipoTrabajoDao;

	private TipoTrabajoDAO(){
		super(TipoTrabajo.class,Integer.class);
	}

	public static TipoTrabajoDAO getInstance() {
		if(tipoTrabajoDao == null)
			tipoTrabajoDao = new TipoTrabajoDAO();
		return tipoTrabajoDao;
	}

	@Override
	public TipoTrabajo findById(Integer id) {
		EntityManager entityManager = EMF.createEntityManager();
		TipoTrabajo tipoTrabajo = entityManager.find(TipoTrabajo.class, id);
		entityManager.close();
		return tipoTrabajo;
	}

	public TipoTrabajo persist(TipoTrabajo tipoTrabajo) {
		EntityManager entityManager = EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(tipoTrabajo);
		entityManager.getTransaction().commit();
		entityManager.close();
		return tipoTrabajo;
	}

	@Override
	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List findAll() {
		throw new UnsupportedOperationException();
	}

}
