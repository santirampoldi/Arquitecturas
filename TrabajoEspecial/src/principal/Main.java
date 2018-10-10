package principal;

import dao.*;
import entidades.*;


public class Main {
	public static void main(String[] args) {
		
		Lugar lugar = new Lugar(1, "Pladema", "Tandil");
//		TipoConocimiento tipoConocimiento = new TipoConocimiento(1, "Conocimiento2");
//		TipoConocimiento tipoConocimiento2 = new TipoConocimiento(2, "Conocimiento2");
//		Tematica tematica = new Tematica(1, "Tema1", tipoConocimiento);
//		Tematica tematica2 = new Tematica(2, "Tema2", tipoConocimiento2);
		TipoTrabajo tipoTrabajo = new TipoTrabajo(1, "Poster");
		Usuario usuario1 = new Usuario(1, "Martin", "Rampoldi", lugar);
//		Usuario usuario2 = new Usuario(2, "Marcelo", "Rampoldi", lugar);
//		Usuario usuario3 = new Usuario(3, "Fernando", "Rampoldi", lugar);
//		Usuario usuario4 = new Usuario(4, "Lionel", "Rampoldi", lugar);
//		List<Usuario>usuarios = new List<Usuario>();
//		Trabajo trabajo = new Trabajo(1, "Pladema", "Tandil");
		
		LugarDAO lugarDAO = LugarDAO.getInstance();
//		TipoConocimientoDAO tipoConocimientoDAO = TipoConocimientoDAO.getInstance();
//		TematicaDAO tematicaDAO = TematicaDAO.getInstance();
		TipoTrabajoDAO tipoTrabajoDAO = TipoTrabajoDAO.getInstance();
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		
		tipoTrabajoDAO.persist(tipoTrabajo);
		lugarDAO.persist(lugar);
		usuarioDAO.persist(usuario1);

//		tipoConocimientoDAO.persist(tipoConocimiento);
//		tipoConocimientoDAO.persist(tipoConocimiento2);
//		tematicaDAO.persist(tematica);
//		tematicaDAO.persist(tematica2);
		
		System.out.println("Finalizado");
	}
}
