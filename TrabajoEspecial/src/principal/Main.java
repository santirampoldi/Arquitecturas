package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import dao.*;
import entidades.*;


public class Main {

	private static Set<Usuario> readerUsuarios(){

		Set<Usuario> retorno = new HashSet<Usuario>();

		String csvFile = "src/resources/Usuarios.csv";
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){			
			br.readLine();

			while ((line = br.readLine()) != null) {
				String[] usuarios = line.split(",");
				int dni = Integer.parseInt(usuarios[0]);

				retorno.add(new Usuario(dni, usuarios[1], usuarios[2]));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return retorno;
	}


	private static Set<Object> readerTrabajos(){

		Set<Object> retorno = new HashSet<Object>();

		String csvFile = "src/resources/Trabajos.csv";
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){			
			br.readLine();

			while ((line = br.readLine()) != null) {
				String[] trabajos = line.split(",");

				retorno.add(new Trabajo(1, trabajos[0]));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return retorno;
	}


	public static void main(String[] args) {

		Set<Usuario>usuarios = readerUsuarios();
		Set<Object>trabajos = readerTrabajos();
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getNombre() + ", " + usuario.getApellido());
		}

		for (Object trabajo : trabajos) {
			System.out.println(((Trabajo) trabajo).getNombre());
		}

		/*
		Tematica tematica1 = new Tematica(1, "Tema1", true);
		Tematica tematica2 = new Tematica(2, "Tema2", false);
		TipoTrabajo tipoTrabajo1 = new TipoTrabajo(1, "Poster");
		TipoTrabajo tipoTrabajo2 = new TipoTrabajo(2, "Articulo");
		TipoTrabajo tipoTrabajo3 = new TipoTrabajo(3, "Poster");


		Set<Tematica>tematicas = new HashSet<Tematica>();
		tematicas.add(tematica1);
		tematicas.add(tematica2);

		Trabajo trabajo1 = new Trabajo(1, "Charla Conicet", tipoTrabajo1, usuarios, tematicas);


		//		Trabajo trabajo2 = new Trabajo(2, "Go", tipoTrabajo, usuarios, tematicas);
		//		Trabajo trabajo3 = new Trabajo(3, "Ruby On Rails", tipoTrabajo, usuarios, tematicas);
		//		Trabajo trabajo4 = new Trabajo(4, "Metodos Agiles", tipoTrabajo, usuarios, tematicas);
		//		Trabajo trabajo5 = new Trabajo(5, "Python", tipoTrabajo, usuarios, tematicas);
		//		Trabajo trabajo6 = new Trabajo(6, "Node Js", tipoTrabajo, usuarios, tematicas);
		//		Trabajo trabajo7 = new Trabajo(7, "Angular Js", tipoTrabajo, usuarios, tematicas);
		//		Trabajo trabajo8 = new Trabajo(8, "BlockChain", tipoTrabajo, usuarios, tematicas);
		//		Trabajo trabajo9 = new Trabajo(9, "Testing", tipoTrabajo, usuarios, tematicas);
		//		Trabajo trabajo10 = new Trabajo(10, "Big Data", tipoTrabajo, usuarios, tematicas);

		LugarDAO lugarDAO = LugarDAO.getInstance();
		TematicaDAO tematicaDAO = TematicaDAO.getInstance();
		TipoTrabajoDAO tipoTrabajoDAO = TipoTrabajoDAO.getInstance();
		UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
		TrabajoDAO trabajoDAO = TrabajoDAO.getInstance();

		tipoTrabajoDAO.persist(tipoTrabajo1);
		tipoTrabajoDAO.persist(tipoTrabajo2);
		tipoTrabajoDAO.persist(tipoTrabajo3);
//		lugarDAO.persist(lugar);
		usuarioDAO.persistMany(usuarios);
		tematicaDAO.persist(tematica1);
		tematicaDAO.persist(tematica2);
		trabajoDAO.persist(trabajo1);


		//		System.out.println(lugar.toString());
		//		System.out.println(tematica1.toString());
		//		System.out.println(tematica2.toString());
		//		System.out.println(tipoTrabajo.toString());
		//		System.out.println(trabajo1.toString());
		//		System.out.println(usuario1.toString());
		//		System.out.println(usuario2.toString());
		//		System.out.println(usuario3.toString());
		//		System.out.println(usuario4.toString());
		//		System.out.println(usuario5.toString());
		//		System.out.println(usuario6.toString());
		//		System.out.println(usuario7.toString());
		//		System.out.println(usuario8.toString());
		//		System.out.println(usuario9.toString());
		//		System.out.println(usuario10.toString());


		System.out.println("Finalizado");
		 */
	}
}
