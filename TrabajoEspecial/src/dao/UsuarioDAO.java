package dao;

import java.util.Set;

import javax.persistence.EntityManager;

import entidades.EMF;
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

//	@Override
//	public List findAll() {
//		throw new UnsupportedOperationException();
//	}

}
