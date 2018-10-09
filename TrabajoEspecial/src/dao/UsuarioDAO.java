package dao;

import java.util.List;

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
		System.out.println("QuiereU");
		return usuario;
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
