package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.EMF;
import entidades.Trabajo;
import entidades.Usuario;    

public class UsuarioDAO extends BaseJpaDAO<Usuario, Integer> {

	private static UsuarioDAO usuarioDao;

	private UsuarioDAO(){
		super(Usuario.class,Integer.class);
	}

	public static UsuarioDAO getInstance() {
		if(usuarioDao == null)
			usuarioDao = new UsuarioDAO();
		return usuarioDao;
	}

	@Override
	public Usuario findById(Integer id) {
		EntityManager entityManager = EMF.createEntityManager();
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.close();
		return usuario;
	}

	public Usuario persist(Usuario usuario) {
		EntityManager entityManager = EMF.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
		return usuario;
	}

	public boolean persistMany(Set<Usuario> usuarios) {
		EntityManager entityManager = EMF.createEntityManager();
		entityManager.getTransaction().begin();
		for (Usuario u : usuarios) {
			entityManager.persist(u);	
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	public List<Trabajo> findAllTrabajosEnEvaluacion(Integer id){
		EntityManager entityManager = EMF.createEntityManager();
		Usuario user = this.findById(id);
		if(user != null) {
			Query query = entityManager.createNativeQuery("SELECT t.* FROM trabajo t JOIN evaluador_trabajo et ON t.id = et.trabajo_id WHERE et.evaluador_id = :id", Trabajo.class);
			query.setParameter("id", id);
			if (!query.getResultList().isEmpty()) {
				return query.getResultList();
			}
		}
		System.out.println("La consulta no devolvio ningun resultado");
		return new ArrayList<Trabajo>();
	}
	
	public List<Trabajo> findAllTrabajosPendientes(Integer id){
		EntityManager entityManager = EMF.createEntityManager();
		Usuario user = this.findById(id);
		if(user != null) {
			Query query = entityManager.createNativeQuery("SELECT t.* FROM trabajo t JOIN evaluador_trabajoPendiente etp ON t.id = etp.trabajoPendiente_id WHERE etp.evaluador_id = :id", Trabajo.class);
			query.setParameter("id", id);
			if (!query.getResultList().isEmpty()) {
				return query.getResultList();
			}
		}
		System.out.println("La consulta no devolvio ningun resultado");
		return new ArrayList<Trabajo>();
	}

	public List<Trabajo> findAllTrabajosAsignados(Integer id){
		//Consideramos a todos los trabajos asignados como los trabajos a evaluar y los trabajos pendientes
		ArrayList<Trabajo> retorno = new ArrayList<Trabajo>();
		retorno.addAll(this.findAllTrabajosEnEvaluacion(id));
		retorno.addAll(this.findAllTrabajosPendientes(id));
		return retorno;
	}

	public List<Usuario> findAllUsuarios(){
		EntityManager entityManager = EMF.createEntityManager();
		List<Usuario>retorno = new ArrayList<Usuario>();
		Query query = entityManager.createNativeQuery("SELECT * FROM usuario", Usuario.class);
		if (!query.getResultList().isEmpty()) {
			retorno = query.getResultList();
			System.out.println(retorno);
			return retorno;
		}
		System.out.println("La consulta no devolvio ningun resultado");
		throw new UnsupportedOperationException();
	}

	//	@Override
	//	public List findAll() {
	//		throw new UnsupportedOperationException();
	//	}

}
