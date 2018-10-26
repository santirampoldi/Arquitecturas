package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.EMF;
import entidades.Evaluacion;

public class EvaluacionDAO extends BaseJpaDAO<Evaluacion, Integer>{

	private static EvaluacionDAO calificacionDao;

	private EvaluacionDAO(){
		super(Evaluacion.class,Integer.class);
	}

	public static EvaluacionDAO getInstance() {
		if(calificacionDao == null)
			calificacionDao = new EvaluacionDAO();
		return calificacionDao;
	}

	public Evaluacion findById(Integer id) {
		EntityManager entityManager = EMF.createEntityManager();
		Evaluacion evaluacion = entityManager.find(Evaluacion.class, id);
		entityManager.close();
		return evaluacion;
	}

	public Evaluacion persist(Evaluacion evaluacion) {
		EntityManager entityManager = EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(evaluacion);
		entityManager.getTransaction().commit();
		entityManager.close();
		return evaluacion;
	}
	
	public void removeAll() {
		EntityManager entityManager = EMF.createEntityManager();
		Query query = entityManager.createNativeQuery("DELETE FROM evaluacion");
		entityManager.getTransaction().begin();
		query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	
}