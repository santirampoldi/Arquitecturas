package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.*;
import entidades.*;


public class Main {
	public static void main(String[] args) {
		
		Lugar lugar = new Lugar(1, "Pladema", "Tandil");
		
		LugarDAO lugarDAO = LugarDAO.getInstance();
		lugarDAO.persist(lugar);
		
		Usuario usuario = new Usuario(1, "Santiago", "Rampoldi", lugar);
		
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		usuarioDAO.persist(usuario);
	}
}
