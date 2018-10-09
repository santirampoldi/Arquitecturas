package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entidades.EMF;
import entidades.TipoConocimiento;    

public class TipoConocimientoDAO extends BaseJpaDAO<TipoConocimiento, Integer> {

	private static TipoConocimientoDAO tipoConocimientoDao;

	private TipoConocimientoDAO(){
		super(TipoConocimiento.class,Integer.class);
	}

	public static TipoConocimientoDAO getInstance() {
		if(tipoConocimientoDao == null)
			tipoConocimientoDao = new TipoConocimientoDAO();
		return tipoConocimientoDao;
	}

	@Override
	public TipoConocimiento findById(Integer id) {
		EntityManager entityManager = EMF.createEntityManager();
		TipoConocimiento tipoConocimiento = entityManager.find(TipoConocimiento.class, id);
		entityManager.close();
		return tipoConocimiento;
	}

	public TipoConocimiento persist(TipoConocimiento tipoConocimiento) {
		EntityManager entityManager = EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(tipoConocimiento);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("QuiereTC");
		return tipoConocimiento;
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
