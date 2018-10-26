package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.EMF;
import entidades.Lugar;    
import entidades.Usuario;

public class LugarDAO extends BaseJpaDAO<Lugar, Integer> {

	private static LugarDAO lugarDao;

	private LugarDAO(){
		super(Lugar.class,Integer.class);
	}

	public static LugarDAO getInstance() {
		if(lugarDao == null)
			lugarDao = new LugarDAO();
		return lugarDao;
	}

	@Override
	public Lugar findById(Integer id) {
		EntityManager entityManager = EMF.createEntityManager();
		Lugar lugar = entityManager.find(Lugar.class, id);
		entityManager.close();
		return lugar;
	}

	public Lugar persist(Lugar lugar) {
		EntityManager entityManager = EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(lugar);
		entityManager.getTransaction().commit();
		entityManager.close();
		return lugar;
	}

	@Override
	public List findAll() {
		throw new UnsupportedOperationException();
	}
	
	public Lugar getFirst(){
		EntityManager entityManager = EMF.createEntityManager();
		Query query = entityManager.createNativeQuery("SELECT * FROM lugar", Lugar.class);
		entityManager.close();
		if (!query.getResultList().isEmpty()) 
			return (Lugar)query.getSingleResult();
		else
			return null;
	}

}
