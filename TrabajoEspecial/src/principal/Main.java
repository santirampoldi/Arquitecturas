package principal;

import java.util.HashSet;
import java.util.Set;

import dao.*;
import entidades.*;


public class Main {
	public static void main(String[] args) {

		Lugar lugar = new Lugar(1, "Pladema", "Tandil");
		TipoConocimiento tipoConocimiento = new TipoConocimiento(1, "Conocimiento1");
		TipoConocimiento tipoConocimiento2 = new TipoConocimiento(2, "Conocimiento2");
		Tematica tematica1 = new Tematica(1, "Tema1", tipoConocimiento);
		Tematica tematica2 = new Tematica(2, "Tema2", tipoConocimiento2);
		TipoTrabajo tipoTrabajo = new TipoTrabajo(1, "Poster");

		Usuario usuario1 = new Usuario(1, "Martin", "Rampoldi", lugar);
		Usuario usuario2 = new Usuario(2, "Marcelo", "Rampoldi", lugar);
		Usuario usuario3 = new Usuario(3, "Fernando", "Rampoldi", lugar);
		Usuario usuario4 = new Usuario(4, "Lionel", "Rampoldi", lugar);
		Usuario usuario5 = new Usuario(5, "Marcelo", "Rampoldi", lugar);
		Usuario usuario6 = new Usuario(6, "Fernando", "Rampoldi", lugar);
		Usuario usuario7 = new Usuario(7, "Lionel", "Rampoldi", lugar);
		Usuario usuario8 = new Usuario(8, "Marcelo", "Rampoldi", lugar);
		Usuario usuario9 = new Usuario(9, "Fernando", "Rampoldi", lugar);
		Usuario usuario10 = new Usuario(10, "Lionel", "Rampoldi", lugar);



		Set<Usuario>usuarios = new HashSet<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		usuarios.add(usuario4);
		usuarios.add(usuario5);
		usuarios.add(usuario6);
		usuarios.add(usuario7);
		usuarios.add(usuario8);
		usuarios.add(usuario9);
		usuarios.add(usuario10);

		Set<Tematica>tematicas = new HashSet<Tematica>();
		tematicas.add(tematica1);
		tematicas.add(tematica2);

		Trabajo trabajo1 = new Trabajo(1, tipoTrabajo, usuarios, tematicas);
		
		usuario3.addTrabajo(trabajo1);
		
//		Trabajo trabajo2 = new Trabajo(2, tipoTrabajo, usuarios, tematicas);
//		Trabajo trabajo3 = new Trabajo(3, tipoTrabajo, usuarios, tematicas);
//		Trabajo trabajo4 = new Trabajo(4, tipoTrabajo, usuarios, tematicas);
//		Trabajo trabajo5 = new Trabajo(5, tipoTrabajo, usuarios, tematicas);
//		Trabajo trabajo6 = new Trabajo(6, tipoTrabajo, usuarios, tematicas);
//		Trabajo trabajo7 = new Trabajo(7, tipoTrabajo, usuarios, tematicas);
//		Trabajo trabajo8 = new Trabajo(8, tipoTrabajo, usuarios, tematicas);
//		Trabajo trabajo9 = new Trabajo(9, tipoTrabajo, usuarios, tematicas);
//		Trabajo trabajo10 = new Trabajo(10, tipoTrabajo, usuarios, tematicas);

		LugarDAO lugarDAO = LugarDAO.getInstance();
		TipoConocimientoDAO tipoConocimientoDAO = TipoConocimientoDAO.getInstance();
		TematicaDAO tematicaDAO = TematicaDAO.getInstance();
		TipoTrabajoDAO tipoTrabajoDAO = TipoTrabajoDAO.getInstance();
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		TrabajoDAO trabajoDAO = TrabajoDAO.getInstance();

		tipoTrabajoDAO.persist(tipoTrabajo);
		lugarDAO.persist(lugar);
		usuarioDAO.persistMany(usuarios);
		tipoConocimientoDAO.persist(tipoConocimiento);
		tipoConocimientoDAO.persist(tipoConocimiento2);
		tematicaDAO.persist(tematica1);
		tematicaDAO.persist(tematica2);
		trabajoDAO.persist(trabajo1);


		System.out.println("Finalizado");
	}
}
