package dao;

import java.util.List;

import javax.persistence.EntityManager;

public class PerroDAO implements DAO<Perro,Integer>{
	
	private static PerroDAO daoPerro;
	
	private PerroDAO(){}

	public static PerroDAO getInstance() {
		if(daoPerro==null)
			daoPerro=new PerroDAO();
		return daoPerro;
	}

	@Override
	public Perro findById(Integer id) {
		
		EntityManager entityManager=EMF.createEntityManager();
		Perro perro=entityManager.find(Perro.class, id);
		entityManager.close();
		return perro;
	
	}

	@Override
	public Perro persist(Perro perro) {
		EntityManager entityManager=EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(perro);
		entityManager.getTransaction().commit();
		entityManager.close();
		return perro;
	}

	@Override
	public List<Perro> findAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Perro update(Integer id, Perro entity) {
		throw new UnsupportedOperationException();
	}

}
