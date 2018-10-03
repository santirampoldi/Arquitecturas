package principal;

import dao.UsuarioDAO;
import entidades.*;


public class Main {
	public static void main(String[] args) {
		
		Lugar lugar = new Lugar(1, "Pladema", "Tandil");
		Usuario usuario = new Usuario(1, "Santiago", "Rampoldi", lugar);
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		usuarioDAO.persist(usuario);
	}
}
