package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entidades.EMF;
import entidades.Tematica;    

public class TematicaDAO extends BaseJpaDAO<Tematica, Integer> {

	private static TematicaDAO tematicaDao;

	private TematicaDAO(){
		super(Tematica.class,Integer.class);
	}

	public static TematicaDAO getInstance() {
		if(tematicaDao == null)
			tematicaDao = new TematicaDAO();
		return tematicaDao;
	}

	@Override
	public Tematica findById(Integer id) {
		EntityManager entityManager = EMF.createEntityManager();
		Tematica tematica = entityManager.find(Tematica.class, id);
		entityManager.close();
		return tematica;
	}

	public Tematica persist(Tematica tematica) {
		EntityManager entityManager = EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(tematica);
		entityManager.getTransaction().commit();
		entityManager.close();
		return tematica;
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
