package dao;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.EMF;
import entidades.Trabajo;
import entidades.Usuario;    

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

	public Set<Usuario> evaluadoresAsignables(Trabajo t) {
		Set<Usuario> retorno = new HashSet<Usuario>();
		//Falta implementar la evaluacion de que usuarios son asignables para los trabajos
		return retorno;
	}

	public Trabajo getTrabajo(Integer id) {
		EntityManager entityManager = EMF.createEntityManager();
		Query query = entityManager.createNativeQuery("SELECT * FROM trabajo WHERE id = :id", Trabajo.class);
		query.setParameter("id", id);
		entityManager.close();
		return (Trabajo) query.getSingleResult();
	}

	public List<Trabajo> findAll() {
		EntityManager entityManager = EMF.createEntityManager();
		Query query = entityManager.createNativeQuery("SELECT * FROM trabajo", Trabajo.class);
		entityManager.close();
		return query.getResultList();
	}

	public boolean delete(Integer id) {
		Trabajo trabajo = this.findById(id);		
		if(trabajo != null) {
			entityManager.remove(trabajo);
			return true;
		}
		return false;
	}
	
	public int getCantidadTrabajos(){
		EntityManager entityManager = EMF.createEntityManager();
		Query query = entityManager.createNativeQuery("SELECT * FROM trabajo", Trabajo.class);
		entityManager.close();
		if (!query.getResultList().isEmpty()) 
			return query.getResultList().size();
		else
			return 0;
	}

}
